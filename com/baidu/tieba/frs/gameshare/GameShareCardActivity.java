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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tbadk.util.g;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.gameshare.a;
import com.tencent.connect.common.Constants;
/* loaded from: classes3.dex */
public class GameShareCardActivity extends BaseActivity implements a.InterfaceC0154a {
    private e cda;
    private a dzo;
    private GameShareData dzp;

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
        bundle.putParcelable(GameShareActivityConfig.KEY_GAME_SHARE_DATA, this.dzp);
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
        if (this.cda == null) {
            this.cda = new e(getActivity(), null);
        }
        if (bundle == null) {
            this.dzp = (GameShareData) getIntent().getParcelableExtra(GameShareActivityConfig.KEY_GAME_SHARE_DATA);
        } else {
            this.dzp = (GameShareData) bundle.getParcelable(GameShareActivityConfig.KEY_GAME_SHARE_DATA);
        }
    }

    private void initView() {
        if (this.dzo == null) {
            this.dzo = new a(getActivity(), this);
        }
        setContentView(this.dzo.getRootView());
        this.dzo.a(this.dzp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.coreExtra.c.d l(Bitmap bitmap) {
        com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
        dVar.f(bitmap);
        dVar.aGp = false;
        dVar.aGo = false;
        dVar.FC();
        return dVar;
    }

    @Override // com.baidu.tieba.frs.gameshare.a.InterfaceC0154a
    public void m(final Bitmap bitmap) {
        if (bitmap != null) {
            TiebaStatic.log(new an("c10125").af("obj_param1", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO).af("obj_type", "4"));
            v.a(new u<com.baidu.tbadk.coreExtra.c.d>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.u
                /* renamed from: ayg */
                public com.baidu.tbadk.coreExtra.c.d doInBackground() {
                    GameShareCardActivity.this.q(bitmap);
                    return GameShareCardActivity.this.l(bitmap);
                }
            }, new g<com.baidu.tbadk.coreExtra.c.d>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.g
                /* renamed from: l */
                public void onReturnDataInUI(com.baidu.tbadk.coreExtra.c.d dVar) {
                    GameShareCardActivity.this.cda.b(dVar);
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.gameshare.a.InterfaceC0154a
    public void n(final Bitmap bitmap) {
        if (bitmap != null) {
            TiebaStatic.log(new an("c10125").af("obj_param1", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO).af("obj_type", "3"));
            v.a(new u<com.baidu.tbadk.coreExtra.c.d>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.u
                /* renamed from: ayg */
                public com.baidu.tbadk.coreExtra.c.d doInBackground() {
                    GameShareCardActivity.this.q(bitmap);
                    return GameShareCardActivity.this.l(bitmap);
                }
            }, new g<com.baidu.tbadk.coreExtra.c.d>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.g
                /* renamed from: l */
                public void onReturnDataInUI(com.baidu.tbadk.coreExtra.c.d dVar) {
                    GameShareCardActivity.this.cda.c(dVar);
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.gameshare.a.InterfaceC0154a
    public void o(final Bitmap bitmap) {
        if (bitmap != null) {
            TiebaStatic.log(new an("c10125").af("obj_param1", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO).af("obj_type", "9"));
            v.a(new u<com.baidu.tbadk.coreExtra.c.d>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.u
                /* renamed from: ayg */
                public com.baidu.tbadk.coreExtra.c.d doInBackground() {
                    GameShareCardActivity.this.q(bitmap);
                    return GameShareCardActivity.this.l(bitmap);
                }
            }, new g<com.baidu.tbadk.coreExtra.c.d>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.g
                /* renamed from: l */
                public void onReturnDataInUI(com.baidu.tbadk.coreExtra.c.d dVar) {
                    GameShareCardActivity.this.cda.d(dVar);
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.gameshare.a.InterfaceC0154a
    public void p(final Bitmap bitmap) {
        if (bitmap != null) {
            TiebaStatic.log(new an("c10125").af("obj_param1", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO).af("obj_type", "7"));
            v.a(new u<com.baidu.tbadk.coreExtra.c.d>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.u
                /* renamed from: ayg */
                public com.baidu.tbadk.coreExtra.c.d doInBackground() {
                    GameShareCardActivity.this.q(bitmap);
                    return GameShareCardActivity.this.l(bitmap);
                }
            }, new g<com.baidu.tbadk.coreExtra.c.d>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.g
                /* renamed from: l */
                public void onReturnDataInUI(com.baidu.tbadk.coreExtra.c.d dVar) {
                    GameShareCardActivity.this.cda.g(dVar);
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.gameshare.a.InterfaceC0154a
    public void onCancel() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dzo != null) {
            this.dzo.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0140d.white_alpha40));
        paint.setTextSize(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.fontsize28));
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(TbadkCoreApplication.getInst().getResources().getString(d.j.game_share_slogon), bitmap.getWidth() / 2, this.dzo.ayi() + TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds50), paint);
        canvas.save(31);
        canvas.restore();
    }
}
