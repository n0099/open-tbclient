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
import com.baidu.tbadk.e.b;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class AdidasBanner extends LinearLayout {
    private com.baidu.tbadk.e.a aFN;
    private b aFO;
    private View cUb;
    private BannerGifView dGj;
    private String mForumId;

    public AdidasBanner(Context context) {
        super(context);
        this.aFO = new b() { // from class: com.baidu.tieba.frs.worldcup.talkball.view.AdidasBanner.1
            @Override // com.baidu.tbadk.e.b
            public boolean v(View view) {
                if (!TextUtils.isEmpty(AdidasBanner.this.mForumId) && view == AdidasBanner.this.dGj.getGifView()) {
                    TiebaStatic.log(new am("c13092").ah(ImageViewerConfig.FORUM_ID, AdidasBanner.this.mForumId).ah("obj_param1", AdidasBanner.this.dGj.getUrl()));
                }
                return false;
            }
        };
        this.aFN = new com.baidu.tbadk.e.a() { // from class: com.baidu.tieba.frs.worldcup.talkball.view.AdidasBanner.2
            @Override // com.baidu.tbadk.e.a
            public void a(View view, boolean z, Object obj) {
                if (z && !TextUtils.isEmpty(AdidasBanner.this.mForumId) && view == AdidasBanner.this.dGj) {
                    TiebaStatic.log(new am("c13091").ah(ImageViewerConfig.FORUM_ID, AdidasBanner.this.mForumId).ah("obj_param1", AdidasBanner.this.dGj.getUrl()));
                }
            }
        };
        initUI();
    }

    private void initUI() {
        setOrientation(1);
        this.dGj = new BannerGifView(getContext(), 5.744f);
        this.dGj.setDefaultResid(d.f.banner_default);
        this.dGj.setErrorResid(d.f.banner_default);
        this.dGj.setNeedNightMask(true);
        this.dGj.setCloseVisibility(false);
        this.dGj.setIWindowChangedListener(this.aFN);
        this.dGj.setOnClickEventListener(this.aFO);
        addView(this.dGj);
        this.cUb = new View(getContext());
        addView(this.cUb);
        this.cUb.setLayoutParams(new LinearLayout.LayoutParams(-1, l.e(getContext(), d.e.tbds12)));
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void ap(String str, String str2) {
        this.dGj.ap(str, str2);
    }

    public void onChangeSkinType(int i) {
        al.e(this.cUb, d.C0141d.cp_bg_line_e, i);
        if (this.dGj != null) {
            this.dGj.onChangeSkinType(i);
        }
    }
}
