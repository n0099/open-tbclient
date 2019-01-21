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
    private final com.baidu.tbadk.f.a aTu;
    private final b aTv;
    private BannerGifView emU;
    private View mDividerView;
    private String mForumId;

    public AdidasBanner(Context context) {
        super(context);
        this.aTv = new b() { // from class: com.baidu.tieba.frs.worldcup.talkball.view.AdidasBanner.1
            @Override // com.baidu.tbadk.f.b
            public boolean F(View view) {
                if (!TextUtils.isEmpty(AdidasBanner.this.mForumId) && view == AdidasBanner.this.emU.getGifView()) {
                    TiebaStatic.log(new am("c13092").aB(ImageViewerConfig.FORUM_ID, AdidasBanner.this.mForumId).aB("obj_param1", AdidasBanner.this.emU.getUrl()));
                }
                return false;
            }
        };
        this.aTu = new com.baidu.tbadk.f.a() { // from class: com.baidu.tieba.frs.worldcup.talkball.view.AdidasBanner.2
            @Override // com.baidu.tbadk.f.a
            public void a(View view, boolean z, Object obj) {
                if (z && !TextUtils.isEmpty(AdidasBanner.this.mForumId) && view == AdidasBanner.this.emU) {
                    TiebaStatic.log(new am("c13091").aB(ImageViewerConfig.FORUM_ID, AdidasBanner.this.mForumId).aB("obj_param1", AdidasBanner.this.emU.getUrl()));
                }
            }
        };
        initUI();
    }

    private void initUI() {
        setOrientation(1);
        this.emU = new BannerGifView(getContext(), 5.744f);
        this.emU.setDefaultResid(e.f.banner_default);
        this.emU.setErrorResid(e.f.banner_default);
        this.emU.setNeedNightMask(true);
        this.emU.setCloseVisibility(false);
        this.emU.setIWindowChangedListener(this.aTu);
        this.emU.setOnClickEventListener(this.aTv);
        addView(this.emU);
        this.mDividerView = new View(getContext());
        addView(this.mDividerView);
        this.mDividerView.setLayoutParams(new LinearLayout.LayoutParams(-1, l.h(getContext(), e.C0210e.tbds12)));
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void aJ(String str, String str2) {
        this.emU.aJ(str, str2);
    }

    public void onChangeSkinType(int i) {
        al.e(this.mDividerView, e.d.cp_bg_line_e, i);
        if (this.emU != null) {
            this.emU.onChangeSkinType(i);
        }
    }
}
