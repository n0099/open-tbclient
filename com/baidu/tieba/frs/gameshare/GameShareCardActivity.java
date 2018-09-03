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
import com.baidu.tbadk.coreExtra.c.d;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tbadk.util.g;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.f;
import com.baidu.tieba.frs.gameshare.a;
import com.tencent.connect.common.Constants;
/* loaded from: classes3.dex */
public class GameShareCardActivity extends BaseActivity implements a.InterfaceC0154a {
    private e ccY;
    private a dzl;
    private GameShareData dzm;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        overridePendingTransition(f.a.pop_enter_anim, f.a.pop_exit_anim);
        initData(bundle);
        initView();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(GameShareActivityConfig.KEY_GAME_SHARE_DATA, this.dzm);
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
        overridePendingTransition(f.a.pop_enter_anim, f.a.pop_exit_anim);
    }

    private void initData(Bundle bundle) {
        if (this.ccY == null) {
            this.ccY = new e(getActivity(), null);
        }
        if (bundle == null) {
            this.dzm = (GameShareData) getIntent().getParcelableExtra(GameShareActivityConfig.KEY_GAME_SHARE_DATA);
        } else {
            this.dzm = (GameShareData) bundle.getParcelable(GameShareActivityConfig.KEY_GAME_SHARE_DATA);
        }
    }

    private void initView() {
        if (this.dzl == null) {
            this.dzl = new a(getActivity(), this);
        }
        setContentView(this.dzl.getRootView());
        this.dzl.a(this.dzm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d l(Bitmap bitmap) {
        d dVar = new d();
        dVar.f(bitmap);
        dVar.aGo = false;
        dVar.aGn = false;
        dVar.FC();
        return dVar;
    }

    @Override // com.baidu.tieba.frs.gameshare.a.InterfaceC0154a
    public void m(final Bitmap bitmap) {
        if (bitmap != null) {
            TiebaStatic.log(new an("c10125").ae("obj_param1", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO).ae("obj_type", "4"));
            v.a(new u<d>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.u
                /* renamed from: aye */
                public d doInBackground() {
                    GameShareCardActivity.this.q(bitmap);
                    return GameShareCardActivity.this.l(bitmap);
                }
            }, new g<d>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.g
                /* renamed from: l */
                public void onReturnDataInUI(d dVar) {
                    GameShareCardActivity.this.ccY.b(dVar);
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.gameshare.a.InterfaceC0154a
    public void n(final Bitmap bitmap) {
        if (bitmap != null) {
            TiebaStatic.log(new an("c10125").ae("obj_param1", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO).ae("obj_type", "3"));
            v.a(new u<d>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.u
                /* renamed from: aye */
                public d doInBackground() {
                    GameShareCardActivity.this.q(bitmap);
                    return GameShareCardActivity.this.l(bitmap);
                }
            }, new g<d>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.g
                /* renamed from: l */
                public void onReturnDataInUI(d dVar) {
                    GameShareCardActivity.this.ccY.c(dVar);
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.gameshare.a.InterfaceC0154a
    public void o(final Bitmap bitmap) {
        if (bitmap != null) {
            TiebaStatic.log(new an("c10125").ae("obj_param1", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO).ae("obj_type", "9"));
            v.a(new u<d>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.u
                /* renamed from: aye */
                public d doInBackground() {
                    GameShareCardActivity.this.q(bitmap);
                    return GameShareCardActivity.this.l(bitmap);
                }
            }, new g<d>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.g
                /* renamed from: l */
                public void onReturnDataInUI(d dVar) {
                    GameShareCardActivity.this.ccY.d(dVar);
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.gameshare.a.InterfaceC0154a
    public void p(final Bitmap bitmap) {
        if (bitmap != null) {
            TiebaStatic.log(new an("c10125").ae("obj_param1", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO).ae("obj_type", "7"));
            v.a(new u<d>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.u
                /* renamed from: aye */
                public d doInBackground() {
                    GameShareCardActivity.this.q(bitmap);
                    return GameShareCardActivity.this.l(bitmap);
                }
            }, new g<d>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.g
                /* renamed from: l */
                public void onReturnDataInUI(d dVar) {
                    GameShareCardActivity.this.ccY.g(dVar);
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
        if (this.dzl != null) {
            this.dzl.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setColor(TbadkCoreApplication.getInst().getResources().getColor(f.d.white_alpha40));
        paint.setTextSize(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.fontsize28));
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(TbadkCoreApplication.getInst().getResources().getString(f.j.game_share_slogon), bitmap.getWidth() / 2, this.dzl.ayg() + TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds50), paint);
        canvas.save(31);
        canvas.restore();
    }
}
