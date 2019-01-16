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
import com.baidu.searchbox.ng.ai.apps.runtime.config.WindowConfig;
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
/* loaded from: classes6.dex */
public class a implements View.OnClickListener, com.baidu.tieba.frs.c.a.a {
    private LinearLayout ecA;
    private RelationBarView ecB;
    private ImageView ecv;
    private TextView ecw;
    private String ecx;
    private View ecy;
    private View ecz;
    private TbPageContext mContext;
    private View rootView;
    private TextView titleText;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.a(a.this.ecv);
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
    private int screenHeight = 0;

    public a(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        this.rootView = LayoutInflater.from(tbPageContext.getContext()).inflate(e.h.frs_head_image_item, (ViewGroup) null, false);
        this.ecy = this.rootView.findViewById(e.g.frs_header_title_container);
        this.ecv = (ImageView) this.rootView.findViewById(e.g.frs_head_image);
        this.titleText = (TextView) this.rootView.findViewById(e.g.frs_header_title);
        this.ecw = (TextView) this.rootView.findViewById(e.g.frs_header_title_lable);
        this.ecz = this.rootView.findViewById(e.g.frs_image_header_contianer);
        aHe();
        this.ecz.getLayoutParams().height = aHd();
        this.ecz.requestLayout();
        this.ecw.setText(tbPageContext.getString(e.j.frs_header_image_lable));
        this.ecv.setOnClickListener(this);
        this.ecy.setOnClickListener(this);
        this.ecz.setOnClickListener(this);
        this.ecA = (LinearLayout) this.rootView.findViewById(e.g.brand_layout);
        this.ecA.setBackgroundColor(0);
        this.ecA.setVisibility(0);
        this.ecB = (RelationBarView) this.rootView.findViewById(e.g.frs_brand_relation_bar_list);
    }

    private int aHd() {
        if (this.screenWidth == 0 || this.screenHeight == 0) {
            return l.h(this.mContext.getPageActivity(), e.C0210e.ds278);
        }
        if (Float.compare(nm(536), 0.0f) == 0 || Float.compare(nm(1080), 0.0f) == 0) {
            return l.h(this.mContext.getPageActivity(), e.C0210e.ds278);
        }
        return (int) ((nm(536) / nm(1080)) * nm(this.screenWidth));
    }

    private float nm(int i) {
        return i * 1.0f;
    }

    private void aHe() {
        if (this.screenWidth == 0 || this.screenHeight == 0) {
            Display defaultDisplay = ((WindowManager) TbadkCoreApplication.getInst().getSystemService(WindowConfig.JSON_WINDOW_KEY)).getDefaultDisplay();
            if (Build.VERSION.SDK_INT >= 13) {
                Point point = new Point();
                defaultDisplay.getSize(point);
                this.screenWidth = point.x;
                this.screenHeight = point.y;
                return;
            }
            this.screenWidth = defaultDisplay.getWidth();
            this.screenHeight = defaultDisplay.getHeight();
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void onChangeSkinType(int i) {
        if (this.ecv != null) {
            al.e(this.ecv, e.d.cp_bg_line_e, i);
        }
        if (this.ecw != null) {
            al.c(this.ecw, e.d.cp_cont_i, i);
        }
        if (this.titleText != null) {
            al.c(this.titleText, e.d.cp_cont_i, i);
        }
        if (this.ecB != null) {
            this.ecB.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void hideTitle() {
        if (this.ecy != null) {
            this.ecy.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public View getHeaderView() {
        return this.rootView;
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public LinearLayout aHf() {
        return this.ecA;
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void a(com.baidu.tieba.tbadkCore.l lVar, String str) {
        if (this.ecv != null) {
            if (TextUtils.isEmpty(str)) {
                this.ecv.setBackgroundResource(e.f.bg_frs_brand_head);
            }
            c.jA().a(str, 10, this.mCallback, 0, 0, null, new Object[0]);
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void setTitle(String str) {
        if (this.titleText != null && this.ecw != null) {
            if (!TextUtils.isEmpty(str)) {
                this.titleText.setText(str);
                this.titleText.setVisibility(0);
            } else {
                this.titleText.setVisibility(8);
            }
            if (TextUtils.isEmpty(this.ecx)) {
                this.ecw.setVisibility(8);
            } else {
                this.ecw.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void setSchemaUrl(String str) {
        this.ecx = str;
    }

    public void bO(List<OriForumInfo> list) {
        this.ecB.setData(list);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.ecx) && this.mContext != null) {
            TiebaStatic.log(new am("c13109").aB("obj_to", this.ecx));
            ay.Es().a(this.mContext, new String[]{this.ecx}, true);
        }
    }
}
