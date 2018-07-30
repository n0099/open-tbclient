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
import com.baidu.tbadk.f.b;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class AdidasBanner extends LinearLayout {
    private final com.baidu.tbadk.f.a aGF;
    private final b aGG;
    private View cUP;
    private BannerGifView dMs;
    private String mForumId;

    public AdidasBanner(Context context) {
        super(context);
        this.aGG = new b() { // from class: com.baidu.tieba.frs.worldcup.talkball.view.AdidasBanner.1
            @Override // com.baidu.tbadk.f.b
            public boolean v(View view) {
                if (!TextUtils.isEmpty(AdidasBanner.this.mForumId) && view == AdidasBanner.this.dMs.getGifView()) {
                    TiebaStatic.log(new an("c13092").af(ImageViewerConfig.FORUM_ID, AdidasBanner.this.mForumId).af("obj_param1", AdidasBanner.this.dMs.getUrl()));
                }
                return false;
            }
        };
        this.aGF = new com.baidu.tbadk.f.a() { // from class: com.baidu.tieba.frs.worldcup.talkball.view.AdidasBanner.2
            @Override // com.baidu.tbadk.f.a
            public void a(View view, boolean z, Object obj) {
                if (z && !TextUtils.isEmpty(AdidasBanner.this.mForumId) && view == AdidasBanner.this.dMs) {
                    TiebaStatic.log(new an("c13091").af(ImageViewerConfig.FORUM_ID, AdidasBanner.this.mForumId).af("obj_param1", AdidasBanner.this.dMs.getUrl()));
                }
            }
        };
        initUI();
    }

    private void initUI() {
        setOrientation(1);
        this.dMs = new BannerGifView(getContext(), 5.744f);
        this.dMs.setDefaultResid(d.f.banner_default);
        this.dMs.setErrorResid(d.f.banner_default);
        this.dMs.setNeedNightMask(true);
        this.dMs.setCloseVisibility(false);
        this.dMs.setIWindowChangedListener(this.aGF);
        this.dMs.setOnClickEventListener(this.aGG);
        addView(this.dMs);
        this.cUP = new View(getContext());
        addView(this.cUP);
        this.cUP.setLayoutParams(new LinearLayout.LayoutParams(-1, l.f(getContext(), d.e.tbds12)));
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void an(String str, String str2) {
        this.dMs.an(str, str2);
    }

    public void onChangeSkinType(int i) {
        am.e(this.cUP, d.C0140d.cp_bg_line_e, i);
        if (this.dMs != null) {
            this.dMs.onChangeSkinType(i);
        }
    }
}
