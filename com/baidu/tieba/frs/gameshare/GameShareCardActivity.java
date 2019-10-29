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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tbadk.coreExtra.c.f;
import com.baidu.tbadk.util.j;
import com.baidu.tbadk.util.y;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gameshare.a;
import com.tencent.connect.common.Constants;
/* loaded from: classes4.dex */
public class GameShareCardActivity extends BaseActivity implements a.InterfaceC0413a {
    private a fJC;
    private f fJD;
    private GameShareData fJE;

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
        bundle.putParcelable(GameShareActivityConfig.KEY_GAME_SHARE_DATA, this.fJE);
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
        if (this.fJD == null) {
            this.fJD = new f(getActivity(), null);
        }
        if (bundle == null) {
            this.fJE = (GameShareData) getIntent().getParcelableExtra(GameShareActivityConfig.KEY_GAME_SHARE_DATA);
        } else {
            this.fJE = (GameShareData) bundle.getParcelable(GameShareActivityConfig.KEY_GAME_SHARE_DATA);
        }
    }

    private void initView() {
        if (this.fJC == null) {
            this.fJC = new a(getActivity(), this);
        }
        setContentView(this.fJC.getRootView());
        this.fJC.a(this.fJE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e s(Bitmap bitmap) {
        e eVar = new e();
        eVar.p(bitmap);
        eVar.cyZ = false;
        eVar.cyY = false;
        eVar.ash();
        return eVar;
    }

    @Override // com.baidu.tieba.frs.gameshare.a.InterfaceC0413a
    public void t(final Bitmap bitmap) {
        if (bitmap != null) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).bS("obj_param1", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO).bS("obj_type", "4"));
            z.a(new y<e>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.y
                /* renamed from: bnU */
                public e doInBackground() {
                    GameShareCardActivity.this.x(bitmap);
                    return GameShareCardActivity.this.s(bitmap);
                }
            }, new j<e>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.j
                /* renamed from: l */
                public void onReturnDataInUI(e eVar) {
                    GameShareCardActivity.this.fJD.e(eVar);
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.gameshare.a.InterfaceC0413a
    public void u(final Bitmap bitmap) {
        if (bitmap != null) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).bS("obj_param1", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO).bS("obj_type", "3"));
            z.a(new y<e>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.y
                /* renamed from: bnU */
                public e doInBackground() {
                    GameShareCardActivity.this.x(bitmap);
                    return GameShareCardActivity.this.s(bitmap);
                }
            }, new j<e>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.j
                /* renamed from: l */
                public void onReturnDataInUI(e eVar) {
                    GameShareCardActivity.this.fJD.f(eVar);
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.gameshare.a.InterfaceC0413a
    public void v(final Bitmap bitmap) {
        if (bitmap != null) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).bS("obj_param1", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO).bS("obj_type", "9"));
            z.a(new y<e>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.y
                /* renamed from: bnU */
                public e doInBackground() {
                    GameShareCardActivity.this.x(bitmap);
                    return GameShareCardActivity.this.s(bitmap);
                }
            }, new j<e>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.j
                /* renamed from: l */
                public void onReturnDataInUI(e eVar) {
                    GameShareCardActivity.this.fJD.g(eVar);
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.gameshare.a.InterfaceC0413a
    public void w(final Bitmap bitmap) {
        if (bitmap != null) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).bS("obj_param1", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO).bS("obj_type", "7"));
            z.a(new y<e>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.y
                /* renamed from: bnU */
                public e doInBackground() {
                    GameShareCardActivity.this.x(bitmap);
                    return GameShareCardActivity.this.s(bitmap);
                }
            }, new j<e>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.j
                /* renamed from: l */
                public void onReturnDataInUI(e eVar) {
                    GameShareCardActivity.this.fJD.j(eVar);
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.gameshare.a.InterfaceC0413a
    public void onCancel() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fJC != null) {
            this.fJC.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.white_alpha40));
        paint.setTextSize(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.fontsize28));
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(TbadkCoreApplication.getInst().getResources().getString(R.string.game_share_slogon), bitmap.getWidth() / 2, this.fJC.bnW() + TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds50), paint);
        canvas.save(31);
        canvas.restore();
    }
}
