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
    private TbPageContext aRR;
    private ImageView dSi;
    private TextView dSj;
    private TextView dSk;
    private String dSl;
    private View dSm;
    private View dSo;
    private View rootView;
    private final b<com.baidu.adp.widget.a.a> mCallback = new b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.frs.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.a(a.this.dSi);
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
    private int dSn = 0;

    public a(TbPageContext tbPageContext) {
        this.aRR = tbPageContext;
        this.rootView = LayoutInflater.from(tbPageContext.getContext()).inflate(d.h.frs_head_image_item, (ViewGroup) null, false);
        this.dSm = this.rootView.findViewById(d.g.frs_header_title_container);
        this.dSi = (ImageView) this.rootView.findViewById(d.g.frs_head_image);
        this.dSj = (TextView) this.rootView.findViewById(d.g.frs_header_title);
        this.dSk = (TextView) this.rootView.findViewById(d.g.frs_header_title_lable);
        this.dSo = this.rootView.findViewById(d.g.frs_image_header_contianer);
        ayZ();
        this.dSo.getLayoutParams().height = ayY();
        this.dSo.requestLayout();
        this.dSk.setText(tbPageContext.getString(d.j.frs_header_image_lable));
        this.dSi.setOnClickListener(this);
        this.dSm.setOnClickListener(this);
        this.dSo.setOnClickListener(this);
    }

    private int ayY() {
        if (this.screenWidth == 0 || this.dSn == 0) {
            return l.t(this.aRR.getPageActivity(), d.e.ds278);
        }
        if (Float.compare(nE(HttpStatus.SC_REQUESTED_RANGE_NOT_SATISFIABLE), 0.0f) == 0 || Float.compare(nE(1080), 0.0f) == 0) {
            return l.t(this.aRR.getPageActivity(), d.e.ds278);
        }
        return (int) ((nE(HttpStatus.SC_REQUESTED_RANGE_NOT_SATISFIABLE) / nE(1080)) * nE(this.screenWidth));
    }

    private float nE(int i) {
        return i * 1.0f;
    }

    private void ayZ() {
        if (this.screenWidth == 0 || this.dSn == 0) {
            Display defaultDisplay = ((WindowManager) TbadkCoreApplication.getInst().getSystemService("window")).getDefaultDisplay();
            if (Build.VERSION.SDK_INT >= 13) {
                Point point = new Point();
                defaultDisplay.getSize(point);
                this.screenWidth = point.x;
                this.dSn = point.y;
                return;
            }
            this.screenWidth = defaultDisplay.getWidth();
            this.dSn = defaultDisplay.getHeight();
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void onChangeSkinType(int i) {
        if (this.dSi != null) {
            aj.g(this.dSi, d.C0140d.cp_bg_line_e, i);
        }
        if (this.dSk != null) {
            aj.e(this.dSk, d.C0140d.cp_cont_i, i);
        }
        if (this.dSj != null) {
            aj.e(this.dSj, d.C0140d.cp_cont_i, i);
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public View getHeaderView() {
        return this.rootView;
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void hB(String str) {
        if (this.dSi != null && !TextUtils.isEmpty(str)) {
            c.nm().a(str, 10, this.mCallback, 0, 0, null, new Object[0]);
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void setTitle(String str) {
        if (this.dSj != null && this.dSk != null) {
            if (!TextUtils.isEmpty(str)) {
                this.dSj.setText(str);
                this.dSk.setVisibility(0);
                this.dSj.setVisibility(0);
                return;
            }
            this.dSk.setVisibility(8);
            this.dSj.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void setSchemaUrl(String str) {
        this.dSl = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.dSl) && this.aRR != null) {
            aw.Du().a(this.aRR, new String[]{this.dSl}, true);
        }
    }
}
