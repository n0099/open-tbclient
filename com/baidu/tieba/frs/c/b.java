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
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.f;
import org.apache.http.HttpStatus;
/* loaded from: classes2.dex */
public class b implements View.OnClickListener, com.baidu.tieba.frs.c.a.a {
    private ImageView dCC;
    private TextView dCD;
    private String dCE;
    private View dCF;
    private View dCH;
    private TbPageContext mContext;
    private View rootView;
    private TextView titleText;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.c.b.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.a(b.this.dCC);
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

    public b(TbPageContext tbPageContext) {
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
    }

    private int azi() {
        if (this.screenWidth == 0 || this.dCG == 0) {
            return l.f(this.mContext.getPageActivity(), f.e.ds278);
        }
        if (Float.compare(lq(HttpStatus.SC_REQUESTED_RANGE_NOT_SATISFIABLE), 0.0f) == 0 || Float.compare(lq(1080), 0.0f) == 0) {
            return l.f(this.mContext.getPageActivity(), f.e.ds278);
        }
        return (int) ((lq(HttpStatus.SC_REQUESTED_RANGE_NOT_SATISFIABLE) / lq(1080)) * lq(this.screenWidth));
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
        return null;
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void hV(String str) {
        if (this.dCC != null && !TextUtils.isEmpty(str)) {
            c.ih().a(str, 10, this.mCallback, 0, 0, null, new Object[0]);
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void setTitle(String str) {
        if (this.titleText != null && this.dCD != null) {
            if (!TextUtils.isEmpty(str)) {
                this.titleText.setText(str);
                this.dCD.setVisibility(0);
                this.titleText.setVisibility(0);
                return;
            }
            this.dCD.setVisibility(8);
            this.titleText.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void setSchemaUrl(String str) {
        this.dCE = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.dCE) && this.mContext != null) {
            az.zI().a(this.mContext, new String[]{this.dCE}, true);
        }
    }
}
