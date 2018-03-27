package com.baidu.tieba.frs.c;

import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.f.c;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.d;
import org.apache.http.HttpStatus;
/* loaded from: classes2.dex */
public class a implements View.OnClickListener, com.baidu.tieba.frs.c.a.a {
    private TbPageContext aRI;
    private ImageView dSb;
    private TextView dSc;
    private TextView dSd;
    private String dSe;
    private View dSf;
    private View dSh;
    private View rootView;
    private final b<com.baidu.adp.widget.a.a> mCallback = new b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.frs.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.a(a.this.dSb);
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
    private int dSg = 0;

    public a(TbPageContext tbPageContext) {
        this.aRI = tbPageContext;
        this.rootView = LayoutInflater.from(tbPageContext.getContext()).inflate(d.h.frs_head_image_item, (ViewGroup) null, false);
        this.dSf = this.rootView.findViewById(d.g.frs_header_title_container);
        this.dSb = (ImageView) this.rootView.findViewById(d.g.frs_head_image);
        this.dSc = (TextView) this.rootView.findViewById(d.g.frs_header_title);
        this.dSd = (TextView) this.rootView.findViewById(d.g.frs_header_title_lable);
        this.dSh = this.rootView.findViewById(d.g.frs_image_header_contianer);
        aza();
        this.dSh.getLayoutParams().height = ayZ();
        this.dSh.requestLayout();
        this.dSd.setText(tbPageContext.getString(d.j.frs_header_image_lable));
        this.dSb.setOnClickListener(this);
        this.dSf.setOnClickListener(this);
        this.dSh.setOnClickListener(this);
    }

    private int ayZ() {
        if (this.screenWidth == 0 || this.dSg == 0) {
            return l.t(this.aRI.getPageActivity(), d.e.ds278);
        }
        if (Float.compare(nE(HttpStatus.SC_REQUESTED_RANGE_NOT_SATISFIABLE), 0.0f) == 0 || Float.compare(nE(1080), 0.0f) == 0) {
            return l.t(this.aRI.getPageActivity(), d.e.ds278);
        }
        return (int) ((nE(HttpStatus.SC_REQUESTED_RANGE_NOT_SATISFIABLE) / nE(1080)) * nE(this.screenWidth));
    }

    private float nE(int i) {
        return i * 1.0f;
    }

    private void aza() {
        if (this.screenWidth == 0 || this.dSg == 0) {
            Display defaultDisplay = ((WindowManager) TbadkCoreApplication.getInst().getSystemService("window")).getDefaultDisplay();
            if (Build.VERSION.SDK_INT >= 13) {
                Point point = new Point();
                defaultDisplay.getSize(point);
                this.screenWidth = point.x;
                this.dSg = point.y;
                return;
            }
            this.screenWidth = defaultDisplay.getWidth();
            this.dSg = defaultDisplay.getHeight();
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void onChangeSkinType(int i) {
        if (this.dSb != null) {
            aj.g(this.dSb, d.C0141d.cp_bg_line_e, i);
        }
        if (this.dSd != null) {
            aj.e(this.dSd, d.C0141d.cp_cont_i, i);
        }
        if (this.dSc != null) {
            aj.e(this.dSc, d.C0141d.cp_cont_i, i);
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void hideTitle() {
        if (this.dSf != null) {
            this.dSf.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void gp(boolean z) {
        if (this.dSb != null) {
            if (z) {
                ColorMatrix colorMatrix = new ColorMatrix();
                colorMatrix.setSaturation(0.0f);
                this.dSb.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            } else {
                this.dSb.setColorFilter((ColorFilter) null);
            }
            this.dSb.postInvalidate();
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public View getHeaderView() {
        return this.rootView;
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void hB(String str) {
        if (this.dSb != null && !TextUtils.isEmpty(str)) {
            c.nm().a(str, 10, this.mCallback, 0, 0, null, new Object[0]);
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void setTitle(String str) {
        if (this.dSc != null && this.dSd != null) {
            if (!TextUtils.isEmpty(str)) {
                this.dSc.setText(str);
                this.dSd.setVisibility(0);
                this.dSc.setVisibility(0);
                return;
            }
            this.dSd.setVisibility(8);
            this.dSc.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void setSchemaUrl(String str) {
        this.dSe = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.dSe) && this.aRI != null) {
            aw.Du().a(this.aRI, new String[]{this.dSe}, true);
        }
    }
}
