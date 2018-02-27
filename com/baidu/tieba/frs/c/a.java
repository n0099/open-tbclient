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
    private TbPageContext aRG;
    private ImageView dRW;
    private TextView dRX;
    private TextView dRY;
    private String dRZ;
    private View dSa;
    private View dSc;
    private View rootView;
    private final b<com.baidu.adp.widget.a.a> mCallback = new b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.frs.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.a(a.this.dRW);
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
    private int dSb = 0;

    public a(TbPageContext tbPageContext) {
        this.aRG = tbPageContext;
        this.rootView = LayoutInflater.from(tbPageContext.getContext()).inflate(d.h.frs_head_image_item, (ViewGroup) null, false);
        this.dSa = this.rootView.findViewById(d.g.frs_header_title_container);
        this.dRW = (ImageView) this.rootView.findViewById(d.g.frs_head_image);
        this.dRX = (TextView) this.rootView.findViewById(d.g.frs_header_title);
        this.dRY = (TextView) this.rootView.findViewById(d.g.frs_header_title_lable);
        this.dSc = this.rootView.findViewById(d.g.frs_image_header_contianer);
        ayY();
        this.dSc.getLayoutParams().height = ayX();
        this.dSc.requestLayout();
        this.dRY.setText(tbPageContext.getString(d.j.frs_header_image_lable));
        this.dRW.setOnClickListener(this);
        this.dSa.setOnClickListener(this);
        this.dSc.setOnClickListener(this);
    }

    private int ayX() {
        if (this.screenWidth == 0 || this.dSb == 0) {
            return l.t(this.aRG.getPageActivity(), d.e.ds278);
        }
        if (Float.compare(nE(HttpStatus.SC_REQUESTED_RANGE_NOT_SATISFIABLE), 0.0f) == 0 || Float.compare(nE(1080), 0.0f) == 0) {
            return l.t(this.aRG.getPageActivity(), d.e.ds278);
        }
        return (int) ((nE(HttpStatus.SC_REQUESTED_RANGE_NOT_SATISFIABLE) / nE(1080)) * nE(this.screenWidth));
    }

    private float nE(int i) {
        return i * 1.0f;
    }

    private void ayY() {
        if (this.screenWidth == 0 || this.dSb == 0) {
            Display defaultDisplay = ((WindowManager) TbadkCoreApplication.getInst().getSystemService("window")).getDefaultDisplay();
            if (Build.VERSION.SDK_INT >= 13) {
                Point point = new Point();
                defaultDisplay.getSize(point);
                this.screenWidth = point.x;
                this.dSb = point.y;
                return;
            }
            this.screenWidth = defaultDisplay.getWidth();
            this.dSb = defaultDisplay.getHeight();
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void onChangeSkinType(int i) {
        if (this.dRW != null) {
            aj.g(this.dRW, d.C0141d.cp_bg_line_e, i);
        }
        if (this.dRY != null) {
            aj.e(this.dRY, d.C0141d.cp_cont_i, i);
        }
        if (this.dRX != null) {
            aj.e(this.dRX, d.C0141d.cp_cont_i, i);
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public View getHeaderView() {
        return this.rootView;
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void hB(String str) {
        if (this.dRW != null && !TextUtils.isEmpty(str)) {
            c.nm().a(str, 10, this.mCallback, 0, 0, null, new Object[0]);
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void setTitle(String str) {
        if (this.dRX != null && this.dRY != null) {
            if (!TextUtils.isEmpty(str)) {
                this.dRX.setText(str);
                this.dRY.setVisibility(0);
                this.dRX.setVisibility(0);
                return;
            }
            this.dRY.setVisibility(8);
            this.dRX.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void setSchemaUrl(String str) {
        this.dRZ = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.dRZ) && this.aRG != null) {
            aw.Dt().a(this.aRG, new String[]{this.dRZ}, true);
        }
    }
}
