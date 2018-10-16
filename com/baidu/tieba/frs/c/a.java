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
    private ImageView dRp;
    private TextView dRq;
    private String dRr;
    private View dRs;
    private View dRt;
    private LinearLayout dRu;
    private RelationBarView dRv;
    private TbPageContext mContext;
    private View rootView;
    private TextView titleText;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.a(a.this.dRp);
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
        this.dRs = this.rootView.findViewById(e.g.frs_header_title_container);
        this.dRp = (ImageView) this.rootView.findViewById(e.g.frs_head_image);
        this.titleText = (TextView) this.rootView.findViewById(e.g.frs_header_title);
        this.dRq = (TextView) this.rootView.findViewById(e.g.frs_header_title_lable);
        this.dRt = this.rootView.findViewById(e.g.frs_image_header_contianer);
        aEK();
        this.dRt.getLayoutParams().height = aEJ();
        this.dRt.requestLayout();
        this.dRq.setText(tbPageContext.getString(e.j.frs_header_image_lable));
        this.dRp.setOnClickListener(this);
        this.dRs.setOnClickListener(this);
        this.dRt.setOnClickListener(this);
        this.dRu = (LinearLayout) this.rootView.findViewById(e.g.brand_layout);
        this.dRu.setBackgroundColor(0);
        this.dRu.setVisibility(0);
        this.dRv = (RelationBarView) this.rootView.findViewById(e.g.frs_brand_relation_bar_list);
    }

    private int aEJ() {
        if (this.screenWidth == 0 || this.screenHeight == 0) {
            return l.h(this.mContext.getPageActivity(), e.C0175e.ds278);
        }
        if (Float.compare(mq(536), 0.0f) == 0 || Float.compare(mq(1080), 0.0f) == 0) {
            return l.h(this.mContext.getPageActivity(), e.C0175e.ds278);
        }
        return (int) ((mq(536) / mq(1080)) * mq(this.screenWidth));
    }

    private float mq(int i) {
        return i * 1.0f;
    }

    private void aEK() {
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
        if (this.dRp != null) {
            al.e(this.dRp, e.d.cp_bg_line_e, i);
        }
        if (this.dRq != null) {
            al.c(this.dRq, e.d.cp_cont_i, i);
        }
        if (this.titleText != null) {
            al.c(this.titleText, e.d.cp_cont_i, i);
        }
        if (this.dRv != null) {
            this.dRv.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void hideTitle() {
        if (this.dRs != null) {
            this.dRs.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public View getHeaderView() {
        return this.rootView;
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public LinearLayout aEL() {
        return this.dRu;
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void iG(String str) {
        if (this.dRp != null) {
            if (TextUtils.isEmpty(str)) {
                this.dRp.setBackgroundResource(e.f.bg_frs_brand_head);
            }
            c.jC().a(str, 10, this.mCallback, 0, 0, null, new Object[0]);
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void setTitle(String str) {
        if (this.titleText != null && this.dRq != null) {
            if (!TextUtils.isEmpty(str)) {
                this.titleText.setText(str);
                this.titleText.setVisibility(0);
            } else {
                this.titleText.setVisibility(8);
            }
            if (TextUtils.isEmpty(this.dRr)) {
                this.dRq.setVisibility(8);
            } else {
                this.dRq.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void setSchemaUrl(String str) {
        this.dRr = str;
    }

    public void bM(List<OriForumInfo> list) {
        this.dRv.setData(list);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.dRr) && this.mContext != null) {
            TiebaStatic.log(new am("c13109").ax("obj_to", this.dRr));
            ay.CU().a(this.mContext, new String[]{this.dRr}, true);
        }
    }
}
