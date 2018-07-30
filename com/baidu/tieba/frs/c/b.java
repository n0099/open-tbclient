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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.d;
import org.apache.http.HttpStatus;
/* loaded from: classes2.dex */
public class b implements View.OnClickListener, com.baidu.tieba.frs.c.a.a {
    private ImageView dCF;
    private TextView dCG;
    private String dCH;
    private View dCI;
    private View dCK;
    private TbPageContext mContext;
    private View rootView;
    private TextView titleText;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.c.b.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.a(b.this.dCF);
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

    public b(TbPageContext tbPageContext) {
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
    }

    private int azk() {
        if (this.screenWidth == 0 || this.dCJ == 0) {
            return l.f(this.mContext.getPageActivity(), d.e.ds278);
        }
        if (Float.compare(lq(HttpStatus.SC_REQUESTED_RANGE_NOT_SATISFIABLE), 0.0f) == 0 || Float.compare(lq(1080), 0.0f) == 0) {
            return l.f(this.mContext.getPageActivity(), d.e.ds278);
        }
        return (int) ((lq(HttpStatus.SC_REQUESTED_RANGE_NOT_SATISFIABLE) / lq(1080)) * lq(this.screenWidth));
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
        return null;
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void hU(String str) {
        if (this.dCF != null && !TextUtils.isEmpty(str)) {
            c.ih().a(str, 10, this.mCallback, 0, 0, null, new Object[0]);
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void setTitle(String str) {
        if (this.titleText != null && this.dCG != null) {
            if (!TextUtils.isEmpty(str)) {
                this.titleText.setText(str);
                this.dCG.setVisibility(0);
                this.titleText.setVisibility(0);
                return;
            }
            this.dCG.setVisibility(8);
            this.titleText.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void setSchemaUrl(String str) {
        this.dCH = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.dCH) && this.mContext != null) {
            ay.zK().a(this.mContext, new String[]{this.dCH}, true);
        }
    }
}
