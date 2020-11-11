package com.baidu.tieba.frs.gameshare;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GameShareActivityConfig;
import com.baidu.tbadk.core.data.GameShareData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.g;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gameshare.a;
/* loaded from: classes22.dex */
public class GameShareCardActivity extends BaseActivity implements a.InterfaceC0729a {
    private a iYj;
    private g iYk;
    private GameShareData iYl;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        overridePendingTransition(R.anim.pop_enter_anim, R.anim.pop_exit_anim);
        initData(bundle);
        initView();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(GameShareActivityConfig.KEY_GAME_SHARE_DATA, this.iYl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 24007 && intent != null && intent.getIntExtra("extra_share_status", 2) == 1) {
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.pop_enter_anim, R.anim.pop_exit_anim);
    }

    private void initData(Bundle bundle) {
        if (this.iYk == null) {
            this.iYk = new g(getActivity(), null);
        }
        if (bundle == null) {
            this.iYl = (GameShareData) getIntent().getParcelableExtra(GameShareActivityConfig.KEY_GAME_SHARE_DATA);
        } else {
            this.iYl = (GameShareData) bundle.getParcelable(GameShareActivityConfig.KEY_GAME_SHARE_DATA);
        }
    }

    private void initView() {
        if (this.iYj == null) {
            this.iYj = new a(getActivity(), this);
        }
        setContentView(this.iYj.getRootView());
        this.iYj.a(this.iYl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ShareItem y(Bitmap bitmap) {
        ShareItem shareItem = new ShareItem();
        shareItem.w(bitmap);
        shareItem.fhj = false;
        shareItem.fhi = false;
        shareItem.bxw();
        return shareItem;
    }

    @Override // com.baidu.tieba.frs.gameshare.a.InterfaceC0729a
    public void z(final Bitmap bitmap) {
        if (bitmap != null) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("obj_param1", "8").dR("obj_type", "4"));
            ae.a(new ad<ShareItem>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ad
                /* renamed from: bjC */
                public ShareItem doInBackground() {
                    GameShareCardActivity.this.D(bitmap);
                    return GameShareCardActivity.this.y(bitmap);
                }
            }, new m<ShareItem>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.m
                /* renamed from: b */
                public void onReturnDataInUI(ShareItem shareItem) {
                    GameShareCardActivity.this.iYk.f(shareItem);
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.gameshare.a.InterfaceC0729a
    public void A(final Bitmap bitmap) {
        if (bitmap != null) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("obj_param1", "8").dR("obj_type", "3"));
            ae.a(new ad<ShareItem>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ad
                /* renamed from: bjC */
                public ShareItem doInBackground() {
                    GameShareCardActivity.this.D(bitmap);
                    return GameShareCardActivity.this.y(bitmap);
                }
            }, new m<ShareItem>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.m
                /* renamed from: b */
                public void onReturnDataInUI(ShareItem shareItem) {
                    GameShareCardActivity.this.iYk.g(shareItem);
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.gameshare.a.InterfaceC0729a
    public void B(final Bitmap bitmap) {
        if (bitmap != null) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("obj_param1", "8").dR("obj_type", "9"));
            ae.a(new ad<ShareItem>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ad
                /* renamed from: bjC */
                public ShareItem doInBackground() {
                    GameShareCardActivity.this.D(bitmap);
                    return GameShareCardActivity.this.y(bitmap);
                }
            }, new m<ShareItem>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.m
                /* renamed from: b */
                public void onReturnDataInUI(ShareItem shareItem) {
                    GameShareCardActivity.this.iYk.h(shareItem);
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.gameshare.a.InterfaceC0729a
    public void C(final Bitmap bitmap) {
        if (bitmap != null) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("obj_param1", "8").dR("obj_type", "7"));
            ae.a(new ad<ShareItem>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ad
                /* renamed from: bjC */
                public ShareItem doInBackground() {
                    GameShareCardActivity.this.D(bitmap);
                    return GameShareCardActivity.this.y(bitmap);
                }
            }, new m<ShareItem>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.m
                /* renamed from: b */
                public void onReturnDataInUI(ShareItem shareItem) {
                    GameShareCardActivity.this.iYk.k(shareItem);
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.gameshare.a.InterfaceC0729a
    public void onCancel() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iYj != null) {
            this.iYj.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.white_alpha40));
        paint.setTextSize(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.fontsize28));
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(TbadkCoreApplication.getInst().getResources().getString(R.string.game_share_slogon), bitmap.getWidth() / 2, this.iYj.cCW() + TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds50), paint);
        canvas.save(31);
        canvas.restore();
    }
}
