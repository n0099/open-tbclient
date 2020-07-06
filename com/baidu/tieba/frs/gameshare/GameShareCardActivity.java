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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gameshare.a;
/* loaded from: classes9.dex */
public class GameShareCardActivity extends BaseActivity implements a.InterfaceC0623a {
    private a hPH;
    private f hPI;
    private GameShareData hPJ;

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
        bundle.putParcelable(GameShareActivityConfig.KEY_GAME_SHARE_DATA, this.hPJ);
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
        if (this.hPI == null) {
            this.hPI = new f(getActivity(), null);
        }
        if (bundle == null) {
            this.hPJ = (GameShareData) getIntent().getParcelableExtra(GameShareActivityConfig.KEY_GAME_SHARE_DATA);
        } else {
            this.hPJ = (GameShareData) bundle.getParcelable(GameShareActivityConfig.KEY_GAME_SHARE_DATA);
        }
    }

    private void initView() {
        if (this.hPH == null) {
            this.hPH = new a(getActivity(), this);
        }
        setContentView(this.hPH.getRootView());
        this.hPH.a(this.hPJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ShareItem v(Bitmap bitmap) {
        ShareItem shareItem = new ShareItem();
        shareItem.t(bitmap);
        shareItem.enT = false;
        shareItem.enS = false;
        shareItem.bdh();
        return shareItem;
    }

    @Override // com.baidu.tieba.frs.gameshare.a.InterfaceC0623a
    public void w(final Bitmap bitmap) {
        if (bitmap != null) {
            TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dk("obj_param1", "8").dk("obj_type", "4"));
            ad.a(new ac<ShareItem>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ac
                /* renamed from: aPv */
                public ShareItem doInBackground() {
                    GameShareCardActivity.this.A(bitmap);
                    return GameShareCardActivity.this.v(bitmap);
                }
            }, new l<ShareItem>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.l
                /* renamed from: b */
                public void onReturnDataInUI(ShareItem shareItem) {
                    GameShareCardActivity.this.hPI.f(shareItem);
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.gameshare.a.InterfaceC0623a
    public void x(final Bitmap bitmap) {
        if (bitmap != null) {
            TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dk("obj_param1", "8").dk("obj_type", "3"));
            ad.a(new ac<ShareItem>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ac
                /* renamed from: aPv */
                public ShareItem doInBackground() {
                    GameShareCardActivity.this.A(bitmap);
                    return GameShareCardActivity.this.v(bitmap);
                }
            }, new l<ShareItem>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.l
                /* renamed from: b */
                public void onReturnDataInUI(ShareItem shareItem) {
                    GameShareCardActivity.this.hPI.g(shareItem);
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.gameshare.a.InterfaceC0623a
    public void y(final Bitmap bitmap) {
        if (bitmap != null) {
            TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dk("obj_param1", "8").dk("obj_type", "9"));
            ad.a(new ac<ShareItem>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ac
                /* renamed from: aPv */
                public ShareItem doInBackground() {
                    GameShareCardActivity.this.A(bitmap);
                    return GameShareCardActivity.this.v(bitmap);
                }
            }, new l<ShareItem>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.l
                /* renamed from: b */
                public void onReturnDataInUI(ShareItem shareItem) {
                    GameShareCardActivity.this.hPI.h(shareItem);
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.gameshare.a.InterfaceC0623a
    public void z(final Bitmap bitmap) {
        if (bitmap != null) {
            TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dk("obj_param1", "8").dk("obj_type", "7"));
            ad.a(new ac<ShareItem>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ac
                /* renamed from: aPv */
                public ShareItem doInBackground() {
                    GameShareCardActivity.this.A(bitmap);
                    return GameShareCardActivity.this.v(bitmap);
                }
            }, new l<ShareItem>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.l
                /* renamed from: b */
                public void onReturnDataInUI(ShareItem shareItem) {
                    GameShareCardActivity.this.hPI.k(shareItem);
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.gameshare.a.InterfaceC0623a
    public void onCancel() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hPH != null) {
            this.hPH.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.white_alpha40));
        paint.setTextSize(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.fontsize28));
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(TbadkCoreApplication.getInst().getResources().getString(R.string.game_share_slogon), bitmap.getWidth() / 2, this.hPH.ccA() + TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds50), paint);
        canvas.save(31);
        canvas.restore();
    }
}
