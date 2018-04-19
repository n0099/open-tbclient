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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.d;
import org.apache.http.HttpStatus;
/* loaded from: classes2.dex */
public class a implements View.OnClickListener, com.baidu.tieba.frs.c.a.a {
    private TbPageContext adf;
    private ImageView dml;
    private TextView dmm;
    private TextView dmn;
    private String dmo;
    private View dmp;
    private View dmr;
    private View rootView;
    private final b<com.baidu.adp.widget.ImageView.a> mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.a(a.this.dml);
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
    private int dmq = 0;

    public a(TbPageContext tbPageContext) {
        this.adf = tbPageContext;
        this.rootView = LayoutInflater.from(tbPageContext.getContext()).inflate(d.i.frs_head_image_item, (ViewGroup) null, false);
        this.dmp = this.rootView.findViewById(d.g.frs_header_title_container);
        this.dml = (ImageView) this.rootView.findViewById(d.g.frs_head_image);
        this.dmm = (TextView) this.rootView.findViewById(d.g.frs_header_title);
        this.dmn = (TextView) this.rootView.findViewById(d.g.frs_header_title_lable);
        this.dmr = this.rootView.findViewById(d.g.frs_image_header_contianer);
        atP();
        this.dmr.getLayoutParams().height = atO();
        this.dmr.requestLayout();
        this.dmn.setText(tbPageContext.getString(d.k.frs_header_image_lable));
        this.dml.setOnClickListener(this);
        this.dmp.setOnClickListener(this);
        this.dmr.setOnClickListener(this);
    }

    private int atO() {
        if (this.screenWidth == 0 || this.dmq == 0) {
            return l.e(this.adf.getPageActivity(), d.e.ds278);
        }
        if (Float.compare(kS(HttpStatus.SC_REQUESTED_RANGE_NOT_SATISFIABLE), 0.0f) == 0 || Float.compare(kS(1080), 0.0f) == 0) {
            return l.e(this.adf.getPageActivity(), d.e.ds278);
        }
        return (int) ((kS(HttpStatus.SC_REQUESTED_RANGE_NOT_SATISFIABLE) / kS(1080)) * kS(this.screenWidth));
    }

    private float kS(int i) {
        return i * 1.0f;
    }

    private void atP() {
        if (this.screenWidth == 0 || this.dmq == 0) {
            Display defaultDisplay = ((WindowManager) TbadkCoreApplication.getInst().getSystemService("window")).getDefaultDisplay();
            if (Build.VERSION.SDK_INT >= 13) {
                Point point = new Point();
                defaultDisplay.getSize(point);
                this.screenWidth = point.x;
                this.dmq = point.y;
                return;
            }
            this.screenWidth = defaultDisplay.getWidth();
            this.dmq = defaultDisplay.getHeight();
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void onChangeSkinType(int i) {
        if (this.dml != null) {
            ak.e(this.dml, d.C0126d.cp_bg_line_e, i);
        }
        if (this.dmn != null) {
            ak.c(this.dmn, d.C0126d.cp_cont_i, i);
        }
        if (this.dmm != null) {
            ak.c(this.dmm, d.C0126d.cp_cont_i, i);
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void hideTitle() {
        if (this.dmp != null) {
            this.dmp.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public View getHeaderView() {
        return this.rootView;
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void hu(String str) {
        if (this.dml != null && !TextUtils.isEmpty(str)) {
            c.fp().a(str, 10, this.mCallback, 0, 0, null, new Object[0]);
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void setTitle(String str) {
        if (this.dmm != null && this.dmn != null) {
            if (!TextUtils.isEmpty(str)) {
                this.dmm.setText(str);
                this.dmn.setVisibility(0);
                this.dmm.setVisibility(0);
                return;
            }
            this.dmn.setVisibility(8);
            this.dmm.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void setSchemaUrl(String str) {
        this.dmo = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (!TextUtils.isEmpty(this.dmo) && this.adf != null) {
            ax.wg().a(this.adf, new String[]{this.dmo}, true);
        }
    }
}
