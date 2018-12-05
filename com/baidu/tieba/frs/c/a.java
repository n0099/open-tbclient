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
    private ImageView dYY;
    private TextView dYZ;
    private String dZa;
    private View dZb;
    private View dZc;
    private LinearLayout dZd;
    private RelationBarView dZe;
    private TbPageContext mContext;
    private View rootView;
    private TextView titleText;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.a(a.this.dYY);
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
        this.dZb = this.rootView.findViewById(e.g.frs_header_title_container);
        this.dYY = (ImageView) this.rootView.findViewById(e.g.frs_head_image);
        this.titleText = (TextView) this.rootView.findViewById(e.g.frs_header_title);
        this.dYZ = (TextView) this.rootView.findViewById(e.g.frs_header_title_lable);
        this.dZc = this.rootView.findViewById(e.g.frs_image_header_contianer);
        aFS();
        this.dZc.getLayoutParams().height = aFR();
        this.dZc.requestLayout();
        this.dYZ.setText(tbPageContext.getString(e.j.frs_header_image_lable));
        this.dYY.setOnClickListener(this);
        this.dZb.setOnClickListener(this);
        this.dZc.setOnClickListener(this);
        this.dZd = (LinearLayout) this.rootView.findViewById(e.g.brand_layout);
        this.dZd.setBackgroundColor(0);
        this.dZd.setVisibility(0);
        this.dZe = (RelationBarView) this.rootView.findViewById(e.g.frs_brand_relation_bar_list);
    }

    private int aFR() {
        if (this.screenWidth == 0 || this.screenHeight == 0) {
            return l.h(this.mContext.getPageActivity(), e.C0210e.ds278);
        }
        if (Float.compare(mY(536), 0.0f) == 0 || Float.compare(mY(1080), 0.0f) == 0) {
            return l.h(this.mContext.getPageActivity(), e.C0210e.ds278);
        }
        return (int) ((mY(536) / mY(1080)) * mY(this.screenWidth));
    }

    private float mY(int i) {
        return i * 1.0f;
    }

    private void aFS() {
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
        if (this.dYY != null) {
            al.e(this.dYY, e.d.cp_bg_line_e, i);
        }
        if (this.dYZ != null) {
            al.c(this.dYZ, e.d.cp_cont_i, i);
        }
        if (this.titleText != null) {
            al.c(this.titleText, e.d.cp_cont_i, i);
        }
        if (this.dZe != null) {
            this.dZe.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void hideTitle() {
        if (this.dZb != null) {
            this.dZb.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public View getHeaderView() {
        return this.rootView;
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public LinearLayout aFT() {
        return this.dZd;
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void a(com.baidu.tieba.tbadkCore.l lVar, String str) {
        if (this.dYY != null) {
            if (TextUtils.isEmpty(str)) {
                this.dYY.setBackgroundResource(e.f.bg_frs_brand_head);
            }
            c.jA().a(str, 10, this.mCallback, 0, 0, null, new Object[0]);
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void setTitle(String str) {
        if (this.titleText != null && this.dYZ != null) {
            if (!TextUtils.isEmpty(str)) {
                this.titleText.setText(str);
                this.titleText.setVisibility(0);
            } else {
                this.titleText.setVisibility(8);
            }
            if (TextUtils.isEmpty(this.dZa)) {
                this.dYZ.setVisibility(8);
            } else {
                this.dYZ.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void setSchemaUrl(String str) {
        this.dZa = str;
    }

    public void bM(List<OriForumInfo> list) {
        this.dZe.setData(list);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.dZa) && this.mContext != null) {
            TiebaStatic.log(new am("c13109").aA("obj_to", this.dZa));
            ay.Ef().a(this.mContext, new String[]{this.dZa}, true);
        }
    }
}
