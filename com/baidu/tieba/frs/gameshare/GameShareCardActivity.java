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
public class GameShareCardActivity extends BaseActivity implements a.InterfaceC0213a {
    private e crx;
    private a dOX;
    private GameShareData dOY;

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
        bundle.putParcelable(GameShareActivityConfig.KEY_GAME_SHARE_DATA, this.dOY);
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
        if (this.crx == null) {
            this.crx = new com.baidu.tbadk.coreExtra.c.e(getActivity(), null);
        }
        if (bundle == null) {
            this.dOY = (GameShareData) getIntent().getParcelableExtra(GameShareActivityConfig.KEY_GAME_SHARE_DATA);
        } else {
            this.dOY = (GameShareData) bundle.getParcelable(GameShareActivityConfig.KEY_GAME_SHARE_DATA);
        }
    }

    private void initView() {
        if (this.dOX == null) {
            this.dOX = new a(getActivity(), this);
        }
        setContentView(this.dOX.getRootView());
        this.dOX.a(this.dOY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d m(Bitmap bitmap) {
        d dVar = new d();
        dVar.g(bitmap);
        dVar.aOU = false;
        dVar.aOT = false;
        dVar.Jf();
        return dVar;
    }

    @Override // com.baidu.tieba.frs.gameshare.a.InterfaceC0213a
    public void n(final Bitmap bitmap) {
        if (bitmap != null) {
            TiebaStatic.log(new am("c10125").ax("obj_param1", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO).ax("obj_type", "4"));
            x.a(new w<d>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.w
                /* renamed from: aDh */
                public d doInBackground() {
                    GameShareCardActivity.this.r(bitmap);
                    return GameShareCardActivity.this.m(bitmap);
                }
            }, new h<d>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.h
                /* renamed from: l */
                public void onReturnDataInUI(d dVar) {
                    GameShareCardActivity.this.crx.b(dVar);
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.gameshare.a.InterfaceC0213a
    public void o(final Bitmap bitmap) {
        if (bitmap != null) {
            TiebaStatic.log(new am("c10125").ax("obj_param1", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO).ax("obj_type", "3"));
            x.a(new w<d>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.w
                /* renamed from: aDh */
                public d doInBackground() {
                    GameShareCardActivity.this.r(bitmap);
                    return GameShareCardActivity.this.m(bitmap);
                }
            }, new h<d>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.h
                /* renamed from: l */
                public void onReturnDataInUI(d dVar) {
                    GameShareCardActivity.this.crx.c(dVar);
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.gameshare.a.InterfaceC0213a
    public void p(final Bitmap bitmap) {
        if (bitmap != null) {
            TiebaStatic.log(new am("c10125").ax("obj_param1", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO).ax("obj_type", "9"));
            x.a(new w<d>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.w
                /* renamed from: aDh */
                public d doInBackground() {
                    GameShareCardActivity.this.r(bitmap);
                    return GameShareCardActivity.this.m(bitmap);
                }
            }, new h<d>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.h
                /* renamed from: l */
                public void onReturnDataInUI(d dVar) {
                    GameShareCardActivity.this.crx.d(dVar);
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.gameshare.a.InterfaceC0213a
    public void q(final Bitmap bitmap) {
        if (bitmap != null) {
            TiebaStatic.log(new am("c10125").ax("obj_param1", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO).ax("obj_type", "7"));
            x.a(new w<d>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.w
                /* renamed from: aDh */
                public d doInBackground() {
                    GameShareCardActivity.this.r(bitmap);
                    return GameShareCardActivity.this.m(bitmap);
                }
            }, new h<d>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.h
                /* renamed from: l */
                public void onReturnDataInUI(d dVar) {
                    GameShareCardActivity.this.crx.g(dVar);
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.gameshare.a.InterfaceC0213a
    public void onCancel() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dOX != null) {
            this.dOX.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setColor(TbadkCoreApplication.getInst().getResources().getColor(e.d.white_alpha40));
        paint.setTextSize(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.fontsize28));
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(TbadkCoreApplication.getInst().getResources().getString(e.j.game_share_slogon), bitmap.getWidth() / 2, this.dOX.aDj() + TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.ds50), paint);
        canvas.save(31);
        canvas.restore();
    }
}
