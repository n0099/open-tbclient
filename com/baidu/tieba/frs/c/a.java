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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.brand.relationbar.RelationBarView;
import java.util.List;
import tbclient.OriForumInfo;
/* loaded from: classes2.dex */
public class a implements View.OnClickListener, com.baidu.tieba.frs.c.a.a {
    private ImageView dCF;
    private TextView dCG;
    private String dCH;
    private View dCI;
    private View dCK;
    private LinearLayout dCL;
    private RelationBarView dCM;
    private TbPageContext mContext;
    private View rootView;
    private TextView titleText;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.a(a.this.dCF);
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
    private int dCJ = 0;

    public a(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        this.rootView = LayoutInflater.from(tbPageContext.getContext()).inflate(d.h.frs_head_image_item, (ViewGroup) null, false);
        this.dCI = this.rootView.findViewById(d.g.frs_header_title_container);
        this.dCF = (ImageView) this.rootView.findViewById(d.g.frs_head_image);
        this.titleText = (TextView) this.rootView.findViewById(d.g.frs_header_title);
        this.dCG = (TextView) this.rootView.findViewById(d.g.frs_header_title_lable);
        this.dCK = this.rootView.findViewById(d.g.frs_image_header_contianer);
        azl();
        this.dCK.getLayoutParams().height = azk();
        this.dCK.requestLayout();
        this.dCG.setText(tbPageContext.getString(d.j.frs_header_image_lable));
        this.dCF.setOnClickListener(this);
        this.dCI.setOnClickListener(this);
        this.dCK.setOnClickListener(this);
        this.dCL = (LinearLayout) this.rootView.findViewById(d.g.brand_layout);
        this.dCL.setBackgroundColor(0);
        this.dCL.setVisibility(0);
        this.dCM = (RelationBarView) this.rootView.findViewById(d.g.frs_brand_relation_bar_list);
    }

    private int azk() {
        if (this.screenWidth == 0 || this.dCJ == 0) {
            return l.f(this.mContext.getPageActivity(), d.e.ds278);
        }
        if (Float.compare(lq(536), 0.0f) == 0 || Float.compare(lq(1080), 0.0f) == 0) {
            return l.f(this.mContext.getPageActivity(), d.e.ds278);
        }
        return (int) ((lq(536) / lq(1080)) * lq(this.screenWidth));
    }

    private float lq(int i) {
        return i * 1.0f;
    }

    private void azl() {
        if (this.screenWidth == 0 || this.dCJ == 0) {
            Display defaultDisplay = ((WindowManager) TbadkCoreApplication.getInst().getSystemService("window")).getDefaultDisplay();
            if (Build.VERSION.SDK_INT >= 13) {
                Point point = new Point();
                defaultDisplay.getSize(point);
                this.screenWidth = point.x;
                this.dCJ = point.y;
                return;
            }
            this.screenWidth = defaultDisplay.getWidth();
            this.dCJ = defaultDisplay.getHeight();
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void onChangeSkinType(int i) {
        if (this.dCF != null) {
            am.e(this.dCF, d.C0140d.cp_bg_line_e, i);
        }
        if (this.dCG != null) {
            am.c(this.dCG, d.C0140d.cp_cont_i, i);
        }
        if (this.titleText != null) {
            am.c(this.titleText, d.C0140d.cp_cont_i, i);
        }
        if (this.dCM != null) {
            this.dCM.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void hideTitle() {
        if (this.dCI != null) {
            this.dCI.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public View getHeaderView() {
        return this.rootView;
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public LinearLayout azm() {
        return this.dCL;
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void hU(String str) {
        if (this.dCF != null) {
            if (TextUtils.isEmpty(str)) {
                this.dCF.setBackgroundResource(d.f.bg_frs_brand_head);
            }
            c.ih().a(str, 10, this.mCallback, 0, 0, null, new Object[0]);
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void setTitle(String str) {
        if (this.titleText != null && this.dCG != null) {
            if (!TextUtils.isEmpty(str)) {
                this.titleText.setText(str);
                this.titleText.setVisibility(0);
            } else {
                this.titleText.setVisibility(8);
            }
            if (TextUtils.isEmpty(this.dCH)) {
                this.dCG.setVisibility(8);
            } else {
                this.dCG.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void setSchemaUrl(String str) {
        this.dCH = str;
    }

    public void bv(List<OriForumInfo> list) {
        this.dCM.setData(list);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.dCH) && this.mContext != null) {
            TiebaStatic.log(new an("c13109").af("obj_to", this.dCH));
            ay.zK().a(this.mContext, new String[]{this.dCH}, true);
        }
    }
}
