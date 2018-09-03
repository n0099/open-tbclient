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
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.f;
import com.baidu.tieba.frs.brand.relationbar.RelationBarView;
import java.util.List;
import tbclient.OriForumInfo;
/* loaded from: classes2.dex */
public class a implements View.OnClickListener, com.baidu.tieba.frs.c.a.a {
    private ImageView dCC;
    private TextView dCD;
    private String dCE;
    private View dCF;
    private View dCH;
    private LinearLayout dCI;
    private RelationBarView dCJ;
    private TbPageContext mContext;
    private View rootView;
    private TextView titleText;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.a(a.this.dCC);
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
    private int dCG = 0;

    public a(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        this.rootView = LayoutInflater.from(tbPageContext.getContext()).inflate(f.h.frs_head_image_item, (ViewGroup) null, false);
        this.dCF = this.rootView.findViewById(f.g.frs_header_title_container);
        this.dCC = (ImageView) this.rootView.findViewById(f.g.frs_head_image);
        this.titleText = (TextView) this.rootView.findViewById(f.g.frs_header_title);
        this.dCD = (TextView) this.rootView.findViewById(f.g.frs_header_title_lable);
        this.dCH = this.rootView.findViewById(f.g.frs_image_header_contianer);
        azj();
        this.dCH.getLayoutParams().height = azi();
        this.dCH.requestLayout();
        this.dCD.setText(tbPageContext.getString(f.j.frs_header_image_lable));
        this.dCC.setOnClickListener(this);
        this.dCF.setOnClickListener(this);
        this.dCH.setOnClickListener(this);
        this.dCI = (LinearLayout) this.rootView.findViewById(f.g.brand_layout);
        this.dCI.setBackgroundColor(0);
        this.dCI.setVisibility(0);
        this.dCJ = (RelationBarView) this.rootView.findViewById(f.g.frs_brand_relation_bar_list);
    }

    private int azi() {
        if (this.screenWidth == 0 || this.dCG == 0) {
            return l.f(this.mContext.getPageActivity(), f.e.ds278);
        }
        if (Float.compare(lq(536), 0.0f) == 0 || Float.compare(lq(1080), 0.0f) == 0) {
            return l.f(this.mContext.getPageActivity(), f.e.ds278);
        }
        return (int) ((lq(536) / lq(1080)) * lq(this.screenWidth));
    }

    private float lq(int i) {
        return i * 1.0f;
    }

    private void azj() {
        if (this.screenWidth == 0 || this.dCG == 0) {
            Display defaultDisplay = ((WindowManager) TbadkCoreApplication.getInst().getSystemService("window")).getDefaultDisplay();
            if (Build.VERSION.SDK_INT >= 13) {
                Point point = new Point();
                defaultDisplay.getSize(point);
                this.screenWidth = point.x;
                this.dCG = point.y;
                return;
            }
            this.screenWidth = defaultDisplay.getWidth();
            this.dCG = defaultDisplay.getHeight();
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void onChangeSkinType(int i) {
        if (this.dCC != null) {
            am.e(this.dCC, f.d.cp_bg_line_e, i);
        }
        if (this.dCD != null) {
            am.c(this.dCD, f.d.cp_cont_i, i);
        }
        if (this.titleText != null) {
            am.c(this.titleText, f.d.cp_cont_i, i);
        }
        if (this.dCJ != null) {
            this.dCJ.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void hideTitle() {
        if (this.dCF != null) {
            this.dCF.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public View getHeaderView() {
        return this.rootView;
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public LinearLayout azk() {
        return this.dCI;
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void hV(String str) {
        if (this.dCC != null) {
            if (TextUtils.isEmpty(str)) {
                this.dCC.setBackgroundResource(f.C0146f.bg_frs_brand_head);
            }
            c.ih().a(str, 10, this.mCallback, 0, 0, null, new Object[0]);
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void setTitle(String str) {
        if (this.titleText != null && this.dCD != null) {
            if (!TextUtils.isEmpty(str)) {
                this.titleText.setText(str);
                this.titleText.setVisibility(0);
            } else {
                this.titleText.setVisibility(8);
            }
            if (TextUtils.isEmpty(this.dCE)) {
                this.dCD.setVisibility(8);
            } else {
                this.dCD.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void setSchemaUrl(String str) {
        this.dCE = str;
    }

    public void bv(List<OriForumInfo> list) {
        this.dCJ.setData(list);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.dCE) && this.mContext != null) {
            TiebaStatic.log(new an("c13109").ae("obj_to", this.dCE));
            az.zI().a(this.mContext, new String[]{this.dCE}, true);
        }
    }
}
