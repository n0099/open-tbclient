package com.baidu.tieba.frs.worldcup.talkball.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.view.BannerGifView;
import com.baidu.tbadk.f.b;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class AdidasBanner extends LinearLayout {
    private final com.baidu.tbadk.f.a aJS;
    private final b aJT;
    private BannerGifView dTG;
    private View daE;
    private String mForumId;

    public AdidasBanner(Context context) {
        super(context);
        this.aJT = new b() { // from class: com.baidu.tieba.frs.worldcup.talkball.view.AdidasBanner.1
            @Override // com.baidu.tbadk.f.b
            public boolean F(View view) {
                if (!TextUtils.isEmpty(AdidasBanner.this.mForumId) && view == AdidasBanner.this.dTG.getGifView()) {
                    TiebaStatic.log(new am("c13092").al(ImageViewerConfig.FORUM_ID, AdidasBanner.this.mForumId).al("obj_param1", AdidasBanner.this.dTG.getUrl()));
                }
                return false;
            }
        };
        this.aJS = new com.baidu.tbadk.f.a() { // from class: com.baidu.tieba.frs.worldcup.talkball.view.AdidasBanner.2
            @Override // com.baidu.tbadk.f.a
            public void a(View view, boolean z, Object obj) {
                if (z && !TextUtils.isEmpty(AdidasBanner.this.mForumId) && view == AdidasBanner.this.dTG) {
                    TiebaStatic.log(new am("c13091").al(ImageViewerConfig.FORUM_ID, AdidasBanner.this.mForumId).al("obj_param1", AdidasBanner.this.dTG.getUrl()));
                }
            }
        };
        initUI();
    }

    private void initUI() {
        setOrientation(1);
        this.dTG = new BannerGifView(getContext(), 5.744f);
        this.dTG.setDefaultResid(e.f.banner_default);
        this.dTG.setErrorResid(e.f.banner_default);
        this.dTG.setNeedNightMask(true);
        this.dTG.setCloseVisibility(false);
        this.dTG.setIWindowChangedListener(this.aJS);
        this.dTG.setOnClickEventListener(this.aJT);
        addView(this.dTG);
        this.daE = new View(getContext());
        addView(this.daE);
        this.daE.setLayoutParams(new LinearLayout.LayoutParams(-1, l.h(getContext(), e.C0141e.tbds12)));
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void au(String str, String str2) {
        this.dTG.au(str, str2);
    }

    public void onChangeSkinType(int i) {
        al.e(this.daE, e.d.cp_bg_line_e, i);
        if (this.dTG != null) {
            this.dTG.onChangeSkinType(i);
        }
    }
}
