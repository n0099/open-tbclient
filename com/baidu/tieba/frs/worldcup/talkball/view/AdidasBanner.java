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
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class AdidasBanner extends LinearLayout {
    private final com.baidu.tbadk.f.a aGE;
    private final b aGF;
    private View cUL;
    private BannerGifView dMo;
    private String mForumId;

    public AdidasBanner(Context context) {
        super(context);
        this.aGF = new b() { // from class: com.baidu.tieba.frs.worldcup.talkball.view.AdidasBanner.1
            @Override // com.baidu.tbadk.f.b
            public boolean v(View view) {
                if (!TextUtils.isEmpty(AdidasBanner.this.mForumId) && view == AdidasBanner.this.dMo.getGifView()) {
                    TiebaStatic.log(new an("c13092").ae(ImageViewerConfig.FORUM_ID, AdidasBanner.this.mForumId).ae("obj_param1", AdidasBanner.this.dMo.getUrl()));
                }
                return false;
            }
        };
        this.aGE = new com.baidu.tbadk.f.a() { // from class: com.baidu.tieba.frs.worldcup.talkball.view.AdidasBanner.2
            @Override // com.baidu.tbadk.f.a
            public void a(View view, boolean z, Object obj) {
                if (z && !TextUtils.isEmpty(AdidasBanner.this.mForumId) && view == AdidasBanner.this.dMo) {
                    TiebaStatic.log(new an("c13091").ae(ImageViewerConfig.FORUM_ID, AdidasBanner.this.mForumId).ae("obj_param1", AdidasBanner.this.dMo.getUrl()));
                }
            }
        };
        initUI();
    }

    private void initUI() {
        setOrientation(1);
        this.dMo = new BannerGifView(getContext(), 5.744f);
        this.dMo.setDefaultResid(f.C0146f.banner_default);
        this.dMo.setErrorResid(f.C0146f.banner_default);
        this.dMo.setNeedNightMask(true);
        this.dMo.setCloseVisibility(false);
        this.dMo.setIWindowChangedListener(this.aGE);
        this.dMo.setOnClickEventListener(this.aGF);
        addView(this.dMo);
        this.cUL = new View(getContext());
        addView(this.cUL);
        this.cUL.setLayoutParams(new LinearLayout.LayoutParams(-1, l.f(getContext(), f.e.tbds12)));
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void am(String str, String str2) {
        this.dMo.am(str, str2);
    }

    public void onChangeSkinType(int i) {
        am.e(this.cUL, f.d.cp_bg_line_e, i);
        if (this.dMo != null) {
            this.dMo.onChangeSkinType(i);
        }
    }
}
