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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.e;
import org.apache.http.HttpStatus;
/* loaded from: classes6.dex */
public class b implements View.OnClickListener, com.baidu.tieba.frs.c.a.a {
    private String ecD;
    private ImageView ecv;
    private TextView ecw;
    private String ecx;
    private View ecy;
    private View ecz;
    private String forumId;
    private TbPageContext mContext;
    private View rootView;
    private TextView titleText;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.c.b.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.a(b.this.ecv);
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

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        this.rootView = LayoutInflater.from(tbPageContext.getContext()).inflate(e.h.frs_head_image_item, (ViewGroup) null, false);
        this.ecy = this.rootView.findViewById(e.g.frs_header_title_container);
        this.ecv = (ImageView) this.rootView.findViewById(e.g.frs_head_image);
        this.titleText = (TextView) this.rootView.findViewById(e.g.frs_header_title);
        this.ecw = (TextView) this.rootView.findViewById(e.g.frs_header_title_lable);
        this.ecz = this.rootView.findViewById(e.g.frs_image_header_contianer);
        aHe();
        this.ecz.getLayoutParams().height = aHd();
        this.ecz.requestLayout();
        this.ecw.setText(tbPageContext.getString(e.j.frs_header_image_lable));
        this.ecv.setOnClickListener(this);
        this.ecy.setOnClickListener(this);
        this.ecz.setOnClickListener(this);
    }

    private int aHd() {
        if (this.screenWidth == 0 || this.screenHeight == 0) {
            return l.h(this.mContext.getPageActivity(), e.C0210e.ds278);
        }
        if (Float.compare(nm(HttpStatus.SC_REQUESTED_RANGE_NOT_SATISFIABLE), 0.0f) == 0 || Float.compare(nm(1080), 0.0f) == 0) {
            return l.h(this.mContext.getPageActivity(), e.C0210e.ds278);
        }
        return (int) ((nm(HttpStatus.SC_REQUESTED_RANGE_NOT_SATISFIABLE) / nm(1080)) * nm(this.screenWidth));
    }

    private float nm(int i) {
        return i * 1.0f;
    }

    private void aHe() {
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
        if (this.ecv != null) {
            al.e(this.ecv, e.d.cp_bg_line_e, i);
        }
        if (this.ecw != null) {
            al.c(this.ecw, e.d.cp_cont_i, i);
        }
        if (this.titleText != null) {
            al.c(this.titleText, e.d.cp_cont_i, i);
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void hideTitle() {
        if (this.ecy != null) {
            this.ecy.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public View getHeaderView() {
        return this.rootView;
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public LinearLayout aHf() {
        return null;
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void a(com.baidu.tieba.tbadkCore.l lVar, String str) {
        if (this.ecv != null && !TextUtils.isEmpty(str)) {
            c.jA().a(str, 10, this.mCallback, 0, 0, null, new Object[0]);
            if (lVar != null && lVar.bhx() != null && !TextUtils.isEmpty(lVar.bhx().getId()) && lVar.bCS() != null && !TextUtils.isEmpty(lVar.bCS().yx())) {
                this.forumId = lVar.bhx().getId();
                this.ecD = lVar.bCS().yx();
            }
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void setTitle(String str) {
        if (this.titleText != null && this.ecw != null) {
            if (!TextUtils.isEmpty(str)) {
                this.titleText.setText(str);
                this.ecw.setVisibility(0);
                this.titleText.setVisibility(0);
                return;
            }
            this.ecw.setVisibility(8);
            this.titleText.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.c.a.a
    public void setSchemaUrl(String str) {
        this.ecx = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.ecx) && this.mContext != null) {
            ay.Es().a(this.mContext, new String[]{this.ecx}, true);
        }
        am amVar = new am("c13330");
        amVar.aB(ImageViewerConfig.FORUM_ID, this.forumId);
        amVar.aB(VideoPlayActivityConfig.OBJ_ID, this.ecD);
        TiebaStatic.log(amVar);
    }
}
