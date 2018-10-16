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
    private final com.baidu.tbadk.f.a aOu;
    private final b aOv;
    private BannerGifView ebz;
    private View mDividerView;
    private String mForumId;

    public AdidasBanner(Context context) {
        super(context);
        this.aOv = new b() { // from class: com.baidu.tieba.frs.worldcup.talkball.view.AdidasBanner.1
            @Override // com.baidu.tbadk.f.b
            public boolean F(View view) {
                if (!TextUtils.isEmpty(AdidasBanner.this.mForumId) && view == AdidasBanner.this.ebz.getGifView()) {
                    TiebaStatic.log(new am("c13092").ax(ImageViewerConfig.FORUM_ID, AdidasBanner.this.mForumId).ax("obj_param1", AdidasBanner.this.ebz.getUrl()));
                }
                return false;
            }
        };
        this.aOu = new com.baidu.tbadk.f.a() { // from class: com.baidu.tieba.frs.worldcup.talkball.view.AdidasBanner.2
            @Override // com.baidu.tbadk.f.a
            public void a(View view, boolean z, Object obj) {
                if (z && !TextUtils.isEmpty(AdidasBanner.this.mForumId) && view == AdidasBanner.this.ebz) {
                    TiebaStatic.log(new am("c13091").ax(ImageViewerConfig.FORUM_ID, AdidasBanner.this.mForumId).ax("obj_param1", AdidasBanner.this.ebz.getUrl()));
                }
            }
        };
        initUI();
    }

    private void initUI() {
        setOrientation(1);
        this.ebz = new BannerGifView(getContext(), 5.744f);
        this.ebz.setDefaultResid(e.f.banner_default);
        this.ebz.setErrorResid(e.f.banner_default);
        this.ebz.setNeedNightMask(true);
        this.ebz.setCloseVisibility(false);
        this.ebz.setIWindowChangedListener(this.aOu);
        this.ebz.setOnClickEventListener(this.aOv);
        addView(this.ebz);
        this.mDividerView = new View(getContext());
        addView(this.mDividerView);
        this.mDividerView.setLayoutParams(new LinearLayout.LayoutParams(-1, l.h(getContext(), e.C0175e.tbds12)));
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void aF(String str, String str2) {
        this.ebz.aF(str, str2);
    }

    public void onChangeSkinType(int i) {
        al.e(this.mDividerView, e.d.cp_bg_line_e, i);
        if (this.ebz != null) {
            this.ebz.onChangeSkinType(i);
        }
    }
}
