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
    private ImageView dnp;
    private TextView dnq;
    private TextView dnr;
    private String dnt;
    private View dnu;
    private View dnw;
    private TbPageContext mContext;
    private View rootView;
    private final b<com.baidu.adp.widget.ImageView.a> mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.a(a.this.dnp);
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
    private int dnv = 0;

    public a(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        this.rootView = LayoutInflater.from(tbPageContext.getContext()).inflate(d.i.frs_head_image_item, (ViewGroup) null, false);
        this.dnu = this.rootView.findViewById(d.g.frs_header_title_container);
        this.dnp = (ImageView) this.rootView.findViewById(d.g.frs_head_image);
        this.dnq = (TextView) this.rootView.findViewById(d.g.frs_header_title);
        this.dnr = (TextView) this.rootView.findViewById(d.g.frs_header_title_lable);
        this.dnw = this.rootView.findViewById(d.g.frs_image_header_contianer);
        atO();
        this.dnw.getLayoutParams().height = atN();
        this.dnw.requestLayout();
        this.dnr.setText(tbPageContext.getString(d.k.frs_header_image_lable));
        this.dnp.setOnClickListener(this);
        this.dnu.setOnClickListener(this);
        this.dnw.setOnClickListener(this);
    }

    private int atN() {
        if (this.screenWidth == 0 || this.dnv == 0) {
            return l.e(this.mContext.getPageActivity(), d.e.ds278);
        }
        if (Float.compare(kR(HttpStatus.SC_REQUESTED_RANGE_NOT_SATISFIABLE), 0.0f) == 0 || Float.compare(kR(1080), 0.0f) == 0) {
            return l.e(this.mContext.getPageActivity(), d.e.ds278);
        }
        return (int) ((kR(HttpStatus.SC_REQUESTED_RANGE_NOT_SATISFIABLE) / kR(1080)) * kR(this.screenWidth));
    }

    private float kR(int i) {
        return i * 1.0f;
    }

    private void atO() {
        if (this.screenWidth == 0 || this.dnv == 0) {
            Display defaultDisplay = ((WindowManager) TbadkCoreApplication.getInst().getSystemService("window")).getDefaultDisplay();
            if (Build.VERSION.SDK_INT >= 13) {
                Point point = new Point();
                defaultDisplay.getSize(point);
                this.screenWidth = point.x;
                this.dnv = point.y;
                return;
            }
            this.screenWidth = defaultDisplay.getWidth();
            this.dnv = defaultDisplay.getHeight();
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void onChangeSkinType(int i) {
        if (this.dnp != null) {
            ak.e(this.dnp, d.C0126d.cp_bg_line_e, i);
        }
        if (this.dnr != null) {
            ak.c(this.dnr, d.C0126d.cp_cont_i, i);
        }
        if (this.dnq != null) {
            ak.c(this.dnq, d.C0126d.cp_cont_i, i);
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void hideTitle() {
        if (this.dnu != null) {
            this.dnu.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public View getHeaderView() {
        return this.rootView;
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void hv(String str) {
        if (this.dnp != null && !TextUtils.isEmpty(str)) {
            c.fp().a(str, 10, this.mCallback, 0, 0, null, new Object[0]);
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void setTitle(String str) {
        if (this.dnq != null && this.dnr != null) {
            if (!TextUtils.isEmpty(str)) {
                this.dnq.setText(str);
                this.dnr.setVisibility(0);
                this.dnq.setVisibility(0);
                return;
            }
            this.dnr.setVisibility(8);
            this.dnq.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void setSchemaUrl(String str) {
        this.dnt = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (!TextUtils.isEmpty(this.dnt) && this.mContext != null) {
            ax.wf().a(this.mContext, new String[]{this.dnt}, true);
        }
    }
}
