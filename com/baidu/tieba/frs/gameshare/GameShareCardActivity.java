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
    private e dLX;
    private a fmA;
    private GameShareData fmB;

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
        bundle.putParcelable(GameShareActivityConfig.KEY_GAME_SHARE_DATA, this.fmB);
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
        if (this.dLX == null) {
            this.dLX = new e(getActivity(), null);
        }
        if (bundle == null) {
            this.fmB = (GameShareData) getIntent().getParcelableExtra(GameShareActivityConfig.KEY_GAME_SHARE_DATA);
        } else {
            this.fmB = (GameShareData) bundle.getParcelable(GameShareActivityConfig.KEY_GAME_SHARE_DATA);
        }
    }

    private void initView() {
        if (this.fmA == null) {
            this.fmA = new a(getActivity(), this);
        }
        setContentView(this.fmA.getRootView());
        this.fmA.a(this.fmB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.coreExtra.c.d t(Bitmap bitmap) {
        com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
        dVar.n(bitmap);
        dVar.cbN = false;
        dVar.cbM = false;
        dVar.ajV();
        return dVar;
    }

    @Override // com.baidu.tieba.frs.gameshare.a.InterfaceC0292a
    public void u(final Bitmap bitmap) {
        if (bitmap != null) {
            TiebaStatic.log(new am("c10125").bJ("obj_param1", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO).bJ("obj_type", "4"));
            aa.a(new z<com.baidu.tbadk.coreExtra.c.d>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.z
                /* renamed from: bgx */
                public com.baidu.tbadk.coreExtra.c.d doInBackground() {
                    GameShareCardActivity.this.y(bitmap);
                    return GameShareCardActivity.this.t(bitmap);
                }
            }, new k<com.baidu.tbadk.coreExtra.c.d>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.k
                /* renamed from: l */
                public void onReturnDataInUI(com.baidu.tbadk.coreExtra.c.d dVar) {
                    GameShareCardActivity.this.dLX.b(dVar);
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
                /* renamed from: bgx */
                public com.baidu.tbadk.coreExtra.c.d doInBackground() {
                    GameShareCardActivity.this.y(bitmap);
                    return GameShareCardActivity.this.t(bitmap);
                }
            }, new k<com.baidu.tbadk.coreExtra.c.d>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.k
                /* renamed from: l */
                public void onReturnDataInUI(com.baidu.tbadk.coreExtra.c.d dVar) {
                    GameShareCardActivity.this.dLX.c(dVar);
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
                /* renamed from: bgx */
                public com.baidu.tbadk.coreExtra.c.d doInBackground() {
                    GameShareCardActivity.this.y(bitmap);
                    return GameShareCardActivity.this.t(bitmap);
                }
            }, new k<com.baidu.tbadk.coreExtra.c.d>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.k
                /* renamed from: l */
                public void onReturnDataInUI(com.baidu.tbadk.coreExtra.c.d dVar) {
                    GameShareCardActivity.this.dLX.d(dVar);
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
                /* renamed from: bgx */
                public com.baidu.tbadk.coreExtra.c.d doInBackground() {
                    GameShareCardActivity.this.y(bitmap);
                    return GameShareCardActivity.this.t(bitmap);
                }
            }, new k<com.baidu.tbadk.coreExtra.c.d>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.k
                /* renamed from: l */
                public void onReturnDataInUI(com.baidu.tbadk.coreExtra.c.d dVar) {
                    GameShareCardActivity.this.dLX.g(dVar);
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
        if (this.fmA != null) {
            this.fmA.onDestroy();
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
        canvas.drawText(TbadkCoreApplication.getInst().getResources().getString(d.j.game_share_slogon), bitmap.getWidth() / 2, this.fmA.bgz() + TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds50), paint);
        canvas.save(31);
        canvas.restore();
    }
}
