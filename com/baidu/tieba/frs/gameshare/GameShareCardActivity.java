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
import com.baidu.tbadk.coreExtra.c.d;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.gameshare.a;
import com.tencent.connect.common.Constants;
/* loaded from: classes3.dex */
public class GameShareCardActivity extends BaseActivity implements a.InterfaceC0224a {
    private e cvq;
    private a dVA;
    private GameShareData dVB;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        overridePendingTransition(e.a.pop_enter_anim, e.a.pop_exit_anim);
        initData(bundle);
        initView();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(GameShareActivityConfig.KEY_GAME_SHARE_DATA, this.dVB);
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
        overridePendingTransition(e.a.pop_enter_anim, e.a.pop_exit_anim);
    }

    private void initData(Bundle bundle) {
        if (this.cvq == null) {
            this.cvq = new com.baidu.tbadk.coreExtra.c.e(getActivity(), null);
        }
        if (bundle == null) {
            this.dVB = (GameShareData) getIntent().getParcelableExtra(GameShareActivityConfig.KEY_GAME_SHARE_DATA);
        } else {
            this.dVB = (GameShareData) bundle.getParcelable(GameShareActivityConfig.KEY_GAME_SHARE_DATA);
        }
    }

    private void initView() {
        if (this.dVA == null) {
            this.dVA = new a(getActivity(), this);
        }
        setContentView(this.dVA.getRootView());
        this.dVA.a(this.dVB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d m(Bitmap bitmap) {
        d dVar = new d();
        dVar.g(bitmap);
        dVar.aSt = false;
        dVar.aSs = false;
        dVar.Kj();
        return dVar;
    }

    @Override // com.baidu.tieba.frs.gameshare.a.InterfaceC0224a
    public void n(final Bitmap bitmap) {
        if (bitmap != null) {
            TiebaStatic.log(new am("c10125").aA("obj_param1", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO).aA("obj_type", "4"));
            x.a(new w<d>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.w
                /* renamed from: aET */
                public d doInBackground() {
                    GameShareCardActivity.this.r(bitmap);
                    return GameShareCardActivity.this.m(bitmap);
                }
            }, new h<d>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.h
                /* renamed from: l */
                public void onReturnDataInUI(d dVar) {
                    GameShareCardActivity.this.cvq.b(dVar);
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.gameshare.a.InterfaceC0224a
    public void o(final Bitmap bitmap) {
        if (bitmap != null) {
            TiebaStatic.log(new am("c10125").aA("obj_param1", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO).aA("obj_type", "3"));
            x.a(new w<d>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.w
                /* renamed from: aET */
                public d doInBackground() {
                    GameShareCardActivity.this.r(bitmap);
                    return GameShareCardActivity.this.m(bitmap);
                }
            }, new h<d>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.h
                /* renamed from: l */
                public void onReturnDataInUI(d dVar) {
                    GameShareCardActivity.this.cvq.c(dVar);
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.gameshare.a.InterfaceC0224a
    public void p(final Bitmap bitmap) {
        if (bitmap != null) {
            TiebaStatic.log(new am("c10125").aA("obj_param1", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO).aA("obj_type", "9"));
            x.a(new w<d>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.w
                /* renamed from: aET */
                public d doInBackground() {
                    GameShareCardActivity.this.r(bitmap);
                    return GameShareCardActivity.this.m(bitmap);
                }
            }, new h<d>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.h
                /* renamed from: l */
                public void onReturnDataInUI(d dVar) {
                    GameShareCardActivity.this.cvq.d(dVar);
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.gameshare.a.InterfaceC0224a
    public void q(final Bitmap bitmap) {
        if (bitmap != null) {
            TiebaStatic.log(new am("c10125").aA("obj_param1", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO).aA("obj_type", "7"));
            x.a(new w<d>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.w
                /* renamed from: aET */
                public d doInBackground() {
                    GameShareCardActivity.this.r(bitmap);
                    return GameShareCardActivity.this.m(bitmap);
                }
            }, new h<d>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.h
                /* renamed from: l */
                public void onReturnDataInUI(d dVar) {
                    GameShareCardActivity.this.cvq.g(dVar);
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.gameshare.a.InterfaceC0224a
    public void onCancel() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dVA != null) {
            this.dVA.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setColor(TbadkCoreApplication.getInst().getResources().getColor(e.d.white_alpha40));
        paint.setTextSize(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.fontsize28));
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(TbadkCoreApplication.getInst().getResources().getString(e.j.game_share_slogon), bitmap.getWidth() / 2, this.dVA.aEV() + TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds50), paint);
        canvas.save(31);
        canvas.restore();
    }
}
