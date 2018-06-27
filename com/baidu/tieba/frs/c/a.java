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
import com.baidu.tieba.d;
import com.baidu.tieba.frs.brand.relationbar.RelationBarView;
import java.util.List;
import tbclient.OriForumInfo;
/* loaded from: classes2.dex */
public class a implements View.OnClickListener, com.baidu.tieba.frs.c.a.a {
    private RelationBarView dAa;
    private ImageView dzT;
    private TextView dzU;
    private String dzV;
    private View dzW;
    private View dzY;
    private LinearLayout dzZ;
    private TbPageContext mContext;
    private View rootView;
    private TextView titleText;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.a(a.this.dzT);
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
    private int dzX = 0;

    public a(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        this.rootView = LayoutInflater.from(tbPageContext.getContext()).inflate(d.i.frs_head_image_item, (ViewGroup) null, false);
        this.dzW = this.rootView.findViewById(d.g.frs_header_title_container);
        this.dzT = (ImageView) this.rootView.findViewById(d.g.frs_head_image);
        this.titleText = (TextView) this.rootView.findViewById(d.g.frs_header_title);
        this.dzU = (TextView) this.rootView.findViewById(d.g.frs_header_title_lable);
        this.dzY = this.rootView.findViewById(d.g.frs_image_header_contianer);
        ayG();
        this.dzY.getLayoutParams().height = ayF();
        this.dzY.requestLayout();
        this.dzU.setText(tbPageContext.getString(d.k.frs_header_image_lable));
        this.dzT.setOnClickListener(this);
        this.dzW.setOnClickListener(this);
        this.dzY.setOnClickListener(this);
        this.dzZ = (LinearLayout) this.rootView.findViewById(d.g.brand_layout);
        this.dzZ.setBackgroundColor(0);
        this.dzZ.setVisibility(0);
        this.dAa = (RelationBarView) this.rootView.findViewById(d.g.frs_brand_relation_bar_list);
    }

    private int ayF() {
        if (this.screenWidth == 0 || this.dzX == 0) {
            return l.e(this.mContext.getPageActivity(), d.e.ds278);
        }
        if (Float.compare(lf(536), 0.0f) == 0 || Float.compare(lf(1080), 0.0f) == 0) {
            return l.e(this.mContext.getPageActivity(), d.e.ds278);
        }
        return (int) ((lf(536) / lf(1080)) * lf(this.screenWidth));
    }

    private float lf(int i) {
        return i * 1.0f;
    }

    private void ayG() {
        if (this.screenWidth == 0 || this.dzX == 0) {
            Display defaultDisplay = ((WindowManager) TbadkCoreApplication.getInst().getSystemService("window")).getDefaultDisplay();
            if (Build.VERSION.SDK_INT >= 13) {
                Point point = new Point();
                defaultDisplay.getSize(point);
                this.screenWidth = point.x;
                this.dzX = point.y;
                return;
            }
            this.screenWidth = defaultDisplay.getWidth();
            this.dzX = defaultDisplay.getHeight();
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void onChangeSkinType(int i) {
        if (this.dzT != null) {
            am.e(this.dzT, d.C0142d.cp_bg_line_e, i);
        }
        if (this.dzU != null) {
            am.c(this.dzU, d.C0142d.cp_cont_i, i);
        }
        if (this.titleText != null) {
            am.c(this.titleText, d.C0142d.cp_cont_i, i);
        }
        if (this.dAa != null) {
            this.dAa.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void hideTitle() {
        if (this.dzW != null) {
            this.dzW.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public View getHeaderView() {
        return this.rootView;
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public LinearLayout ayH() {
        return this.dzZ;
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void hX(String str) {
        if (this.dzT != null) {
            if (TextUtils.isEmpty(str)) {
                this.dzT.setBackgroundResource(d.f.bg_frs_brand_head);
            }
            c.ig().a(str, 10, this.mCallback, 0, 0, null, new Object[0]);
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void setTitle(String str) {
        if (this.titleText != null && this.dzU != null) {
            if (!TextUtils.isEmpty(str)) {
                this.titleText.setText(str);
                this.titleText.setVisibility(0);
            } else {
                this.titleText.setVisibility(8);
            }
            if (TextUtils.isEmpty(this.dzV)) {
                this.dzU.setVisibility(8);
            } else {
                this.dzU.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void setSchemaUrl(String str) {
        this.dzV = str;
    }

    public void bw(List<OriForumInfo> list) {
        this.dAa.setData(list);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.dzV) && this.mContext != null) {
            TiebaStatic.log(new an("c13109").ah("obj_to", this.dzV));
            az.zV().a(this.mContext, new String[]{this.dzV}, true);
        }
    }
}
