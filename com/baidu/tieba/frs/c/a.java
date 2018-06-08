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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.d;
import org.apache.http.HttpStatus;
/* loaded from: classes2.dex */
public class a implements View.OnClickListener, com.baidu.tieba.frs.c.a.a {
    private ImageView dwH;
    private TextView dwI;
    private TextView dwJ;
    private String dwK;
    private View dwL;
    private View dwN;
    private TbPageContext mContext;
    private View rootView;
    private final b<com.baidu.adp.widget.ImageView.a> mCallback = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.a(a.this.dwH);
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
    private int dwM = 0;

    public a(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        this.rootView = LayoutInflater.from(tbPageContext.getContext()).inflate(d.i.frs_head_image_item, (ViewGroup) null, false);
        this.dwL = this.rootView.findViewById(d.g.frs_header_title_container);
        this.dwH = (ImageView) this.rootView.findViewById(d.g.frs_head_image);
        this.dwI = (TextView) this.rootView.findViewById(d.g.frs_header_title);
        this.dwJ = (TextView) this.rootView.findViewById(d.g.frs_header_title_lable);
        this.dwN = this.rootView.findViewById(d.g.frs_image_header_contianer);
        ayb();
        this.dwN.getLayoutParams().height = aya();
        this.dwN.requestLayout();
        this.dwJ.setText(tbPageContext.getString(d.k.frs_header_image_lable));
        this.dwH.setOnClickListener(this);
        this.dwL.setOnClickListener(this);
        this.dwN.setOnClickListener(this);
    }

    private int aya() {
        if (this.screenWidth == 0 || this.dwM == 0) {
            return l.e(this.mContext.getPageActivity(), d.e.ds278);
        }
        if (Float.compare(kY(HttpStatus.SC_REQUESTED_RANGE_NOT_SATISFIABLE), 0.0f) == 0 || Float.compare(kY(1080), 0.0f) == 0) {
            return l.e(this.mContext.getPageActivity(), d.e.ds278);
        }
        return (int) ((kY(HttpStatus.SC_REQUESTED_RANGE_NOT_SATISFIABLE) / kY(1080)) * kY(this.screenWidth));
    }

    private float kY(int i) {
        return i * 1.0f;
    }

    private void ayb() {
        if (this.screenWidth == 0 || this.dwM == 0) {
            Display defaultDisplay = ((WindowManager) TbadkCoreApplication.getInst().getSystemService("window")).getDefaultDisplay();
            if (Build.VERSION.SDK_INT >= 13) {
                Point point = new Point();
                defaultDisplay.getSize(point);
                this.screenWidth = point.x;
                this.dwM = point.y;
                return;
            }
            this.screenWidth = defaultDisplay.getWidth();
            this.dwM = defaultDisplay.getHeight();
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void onChangeSkinType(int i) {
        if (this.dwH != null) {
            al.e(this.dwH, d.C0141d.cp_bg_line_e, i);
        }
        if (this.dwJ != null) {
            al.c(this.dwJ, d.C0141d.cp_cont_i, i);
        }
        if (this.dwI != null) {
            al.c(this.dwI, d.C0141d.cp_cont_i, i);
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void hideTitle() {
        if (this.dwL != null) {
            this.dwL.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public View getHeaderView() {
        return this.rootView;
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void hT(String str) {
        if (this.dwH != null && !TextUtils.isEmpty(str)) {
            c.ig().a(str, 10, this.mCallback, 0, 0, null, new Object[0]);
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void setTitle(String str) {
        if (this.dwI != null && this.dwJ != null) {
            if (!TextUtils.isEmpty(str)) {
                this.dwI.setText(str);
                this.dwJ.setVisibility(0);
                this.dwI.setVisibility(0);
                return;
            }
            this.dwJ.setVisibility(8);
            this.dwI.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void setSchemaUrl(String str) {
        this.dwK = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.dwK) && this.mContext != null) {
            ay.zG().a(this.mContext, new String[]{this.dwK}, true);
        }
    }
}
