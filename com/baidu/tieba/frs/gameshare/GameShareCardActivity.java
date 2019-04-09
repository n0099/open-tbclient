package com.baidu.tieba.frs.gameshare;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GameShareActivityConfig;
import com.baidu.tbadk.core.data.GameShareData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.gameshare.a;
import com.tencent.connect.common.Constants;
/* loaded from: classes4.dex */
public class GameShareCardActivity extends BaseActivity implements a.InterfaceC0292a {
    private e dLp;
    private a fmm;
    private GameShareData fmn;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        overridePendingTransition(d.a.pop_enter_anim, d.a.pop_exit_anim);
        initData(bundle);
        initView();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(GameShareActivityConfig.KEY_GAME_SHARE_DATA, this.fmn);
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
        overridePendingTransition(d.a.pop_enter_anim, d.a.pop_exit_anim);
    }

    private void initData(Bundle bundle) {
        if (this.dLp == null) {
            this.dLp = new e(getActivity(), null);
        }
        if (bundle == null) {
            this.fmn = (GameShareData) getIntent().getParcelableExtra(GameShareActivityConfig.KEY_GAME_SHARE_DATA);
        } else {
            this.fmn = (GameShareData) bundle.getParcelable(GameShareActivityConfig.KEY_GAME_SHARE_DATA);
        }
    }

    private void initView() {
        if (this.fmm == null) {
            this.fmm = new a(getActivity(), this);
        }
        setContentView(this.fmm.getRootView());
        this.fmm.a(this.fmn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.coreExtra.c.d t(Bitmap bitmap) {
        com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
        dVar.n(bitmap);
        dVar.cbQ = false;
        dVar.cbP = false;
        dVar.ajS();
        return dVar;
    }

    @Override // com.baidu.tieba.frs.gameshare.a.InterfaceC0292a
    public void u(final Bitmap bitmap) {
        if (bitmap != null) {
            TiebaStatic.log(new am("c10125").bJ("obj_param1", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO).bJ("obj_type", "4"));
            aa.a(new z<com.baidu.tbadk.coreExtra.c.d>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.z
                /* renamed from: bgv */
                public com.baidu.tbadk.coreExtra.c.d doInBackground() {
                    GameShareCardActivity.this.y(bitmap);
                    return GameShareCardActivity.this.t(bitmap);
                }
            }, new k<com.baidu.tbadk.coreExtra.c.d>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.k
                /* renamed from: l */
                public void onReturnDataInUI(com.baidu.tbadk.coreExtra.c.d dVar) {
                    GameShareCardActivity.this.dLp.b(dVar);
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.gameshare.a.InterfaceC0292a
    public void v(final Bitmap bitmap) {
        if (bitmap != null) {
            TiebaStatic.log(new am("c10125").bJ("obj_param1", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO).bJ("obj_type", "3"));
            aa.a(new z<com.baidu.tbadk.coreExtra.c.d>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.z
                /* renamed from: bgv */
                public com.baidu.tbadk.coreExtra.c.d doInBackground() {
                    GameShareCardActivity.this.y(bitmap);
                    return GameShareCardActivity.this.t(bitmap);
                }
            }, new k<com.baidu.tbadk.coreExtra.c.d>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.k
                /* renamed from: l */
                public void onReturnDataInUI(com.baidu.tbadk.coreExtra.c.d dVar) {
                    GameShareCardActivity.this.dLp.c(dVar);
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.gameshare.a.InterfaceC0292a
    public void w(final Bitmap bitmap) {
        if (bitmap != null) {
            TiebaStatic.log(new am("c10125").bJ("obj_param1", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO).bJ("obj_type", "9"));
            aa.a(new z<com.baidu.tbadk.coreExtra.c.d>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.z
                /* renamed from: bgv */
                public com.baidu.tbadk.coreExtra.c.d doInBackground() {
                    GameShareCardActivity.this.y(bitmap);
                    return GameShareCardActivity.this.t(bitmap);
                }
            }, new k<com.baidu.tbadk.coreExtra.c.d>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.k
                /* renamed from: l */
                public void onReturnDataInUI(com.baidu.tbadk.coreExtra.c.d dVar) {
                    GameShareCardActivity.this.dLp.d(dVar);
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.gameshare.a.InterfaceC0292a
    public void x(final Bitmap bitmap) {
        if (bitmap != null) {
            TiebaStatic.log(new am("c10125").bJ("obj_param1", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO).bJ("obj_type", "7"));
            aa.a(new z<com.baidu.tbadk.coreExtra.c.d>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.z
                /* renamed from: bgv */
                public com.baidu.tbadk.coreExtra.c.d doInBackground() {
                    GameShareCardActivity.this.y(bitmap);
                    return GameShareCardActivity.this.t(bitmap);
                }
            }, new k<com.baidu.tbadk.coreExtra.c.d>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.k
                /* renamed from: l */
                public void onReturnDataInUI(com.baidu.tbadk.coreExtra.c.d dVar) {
                    GameShareCardActivity.this.dLp.g(dVar);
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.gameshare.a.InterfaceC0292a
    public void onCancel() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fmm != null) {
            this.fmm.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0277d.white_alpha40));
        paint.setTextSize(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.fontsize28));
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(TbadkCoreApplication.getInst().getResources().getString(d.j.game_share_slogon), bitmap.getWidth() / 2, this.fmm.bgx() + TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds50), paint);
        canvas.save(31);
        canvas.restore();
    }
}
