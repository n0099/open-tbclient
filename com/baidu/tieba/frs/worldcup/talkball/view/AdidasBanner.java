package com.baidu.tieba.frs.worldcup.talkball.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.coreExtra.view.BannerGifView;
import com.baidu.tbadk.e.b;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class AdidasBanner extends LinearLayout {
    private final com.baidu.tbadk.e.a aGF;
    private final b aGG;
    private View cSc;
    private BannerGifView dJC;
    private String mForumId;

    public AdidasBanner(Context context) {
        super(context);
        this.aGG = new b() { // from class: com.baidu.tieba.frs.worldcup.talkball.view.AdidasBanner.1
            @Override // com.baidu.tbadk.e.b
            public boolean v(View view) {
                if (!TextUtils.isEmpty(AdidasBanner.this.mForumId) && view == AdidasBanner.this.dJC.getGifView()) {
                    TiebaStatic.log(new an("c13092").ah(ImageViewerConfig.FORUM_ID, AdidasBanner.this.mForumId).ah("obj_param1", AdidasBanner.this.dJC.getUrl()));
                }
                return false;
            }
        };
        this.aGF = new com.baidu.tbadk.e.a() { // from class: com.baidu.tieba.frs.worldcup.talkball.view.AdidasBanner.2
            @Override // com.baidu.tbadk.e.a
            public void a(View view, boolean z, Object obj) {
                if (z && !TextUtils.isEmpty(AdidasBanner.this.mForumId) && view == AdidasBanner.this.dJC) {
                    TiebaStatic.log(new an("c13091").ah(ImageViewerConfig.FORUM_ID, AdidasBanner.this.mForumId).ah("obj_param1", AdidasBanner.this.dJC.getUrl()));
                }
            }
        };
        initUI();
    }

    private void initUI() {
        setOrientation(1);
        this.dJC = new BannerGifView(getContext(), 5.744f);
        this.dJC.setDefaultResid(d.f.banner_default);
        this.dJC.setErrorResid(d.f.banner_default);
        this.dJC.setNeedNightMask(true);
        this.dJC.setCloseVisibility(false);
        this.dJC.setIWindowChangedListener(this.aGF);
        this.dJC.setOnClickEventListener(this.aGG);
        addView(this.dJC);
        this.cSc = new View(getContext());
        addView(this.cSc);
        this.cSc.setLayoutParams(new LinearLayout.LayoutParams(-1, l.e(getContext(), d.e.tbds12)));
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void ap(String str, String str2) {
        this.dJC.ap(str, str2);
    }

    public void onChangeSkinType(int i) {
        am.e(this.cSc, d.C0142d.cp_bg_line_e, i);
        if (this.dJC != null) {
            this.dJC.onChangeSkinType(i);
        }
    }
}
