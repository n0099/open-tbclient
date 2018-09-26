package com.baidu.tieba.frs.c;

import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.f.c;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.brand.relationbar.RelationBarView;
import java.util.List;
import tbclient.OriForumInfo;
/* loaded from: classes2.dex */
public class a implements View.OnClickListener, com.baidu.tieba.frs.c.a.a {
    private ImageView dJs;
    private TextView dJt;
    private String dJu;
    private View dJv;
    private View dJx;
    private LinearLayout dJy;
    private RelationBarView dJz;
    private TbPageContext mContext;
    private View rootView;
    private TextView titleText;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.a(a.this.dJs);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onProgressUpdate(Object... objArr) {
            super.onProgressUpdate(objArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onCancelled(String str) {
            super.onCancelled(str);
        }
    };
    private int screenWidth = 0;
    private int dJw = 0;

    public a(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        this.rootView = LayoutInflater.from(tbPageContext.getContext()).inflate(e.h.frs_head_image_item, (ViewGroup) null, false);
        this.dJv = this.rootView.findViewById(e.g.frs_header_title_container);
        this.dJs = (ImageView) this.rootView.findViewById(e.g.frs_head_image);
        this.titleText = (TextView) this.rootView.findViewById(e.g.frs_header_title);
        this.dJt = (TextView) this.rootView.findViewById(e.g.frs_header_title_lable);
        this.dJx = this.rootView.findViewById(e.g.frs_image_header_contianer);
        aBr();
        this.dJx.getLayoutParams().height = aBq();
        this.dJx.requestLayout();
        this.dJt.setText(tbPageContext.getString(e.j.frs_header_image_lable));
        this.dJs.setOnClickListener(this);
        this.dJv.setOnClickListener(this);
        this.dJx.setOnClickListener(this);
        this.dJy = (LinearLayout) this.rootView.findViewById(e.g.brand_layout);
        this.dJy.setBackgroundColor(0);
        this.dJy.setVisibility(0);
        this.dJz = (RelationBarView) this.rootView.findViewById(e.g.frs_brand_relation_bar_list);
    }

    private int aBq() {
        if (this.screenWidth == 0 || this.dJw == 0) {
            return l.h(this.mContext.getPageActivity(), e.C0141e.ds278);
        }
        if (Float.compare(lS(536), 0.0f) == 0 || Float.compare(lS(1080), 0.0f) == 0) {
            return l.h(this.mContext.getPageActivity(), e.C0141e.ds278);
        }
        return (int) ((lS(536) / lS(1080)) * lS(this.screenWidth));
    }

    private float lS(int i) {
        return i * 1.0f;
    }

    private void aBr() {
        if (this.screenWidth == 0 || this.dJw == 0) {
            Display defaultDisplay = ((WindowManager) TbadkCoreApplication.getInst().getSystemService("window")).getDefaultDisplay();
            if (Build.VERSION.SDK_INT >= 13) {
                Point point = new Point();
                defaultDisplay.getSize(point);
                this.screenWidth = point.x;
                this.dJw = point.y;
                return;
            }
            this.screenWidth = defaultDisplay.getWidth();
            this.dJw = defaultDisplay.getHeight();
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void onChangeSkinType(int i) {
        if (this.dJs != null) {
            al.e(this.dJs, e.d.cp_bg_line_e, i);
        }
        if (this.dJt != null) {
            al.c(this.dJt, e.d.cp_cont_i, i);
        }
        if (this.titleText != null) {
            al.c(this.titleText, e.d.cp_cont_i, i);
        }
        if (this.dJz != null) {
            this.dJz.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void hideTitle() {
        if (this.dJv != null) {
            this.dJv.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public View getHeaderView() {
        return this.rootView;
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public LinearLayout aBs() {
        return this.dJy;
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void it(String str) {
        if (this.dJs != null) {
            if (TextUtils.isEmpty(str)) {
                this.dJs.setBackgroundResource(e.f.bg_frs_brand_head);
            }
            c.jn().a(str, 10, this.mCallback, 0, 0, null, new Object[0]);
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void setTitle(String str) {
        if (this.titleText != null && this.dJt != null) {
            if (!TextUtils.isEmpty(str)) {
                this.titleText.setText(str);
                this.titleText.setVisibility(0);
            } else {
                this.titleText.setVisibility(8);
            }
            if (TextUtils.isEmpty(this.dJu)) {
                this.dJt.setVisibility(8);
            } else {
                this.dJt.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void setSchemaUrl(String str) {
        this.dJu = str;
    }

    public void bw(List<OriForumInfo> list) {
        this.dJz.setData(list);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.dJu) && this.mContext != null) {
            TiebaStatic.log(new am("c13109").al("obj_to", this.dJu));
            ay.AN().a(this.mContext, new String[]{this.dJu}, true);
        }
    }
}
