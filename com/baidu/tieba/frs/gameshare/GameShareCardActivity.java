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
import com.baidu.tbadk.coreExtra.c.f;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gameshare.a;
import com.tencent.connect.common.Constants;
/* loaded from: classes4.dex */
public class GameShareCardActivity extends BaseActivity implements a.InterfaceC0313a {
    private f dZO;
    private a fIu;
    private GameShareData fIv;

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
        bundle.putParcelable(GameShareActivityConfig.KEY_GAME_SHARE_DATA, this.fIv);
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
        if (this.dZO == null) {
            this.dZO = new f(getActivity(), null);
        }
        if (bundle == null) {
            this.fIv = (GameShareData) getIntent().getParcelableExtra(GameShareActivityConfig.KEY_GAME_SHARE_DATA);
        } else {
            this.fIv = (GameShareData) bundle.getParcelable(GameShareActivityConfig.KEY_GAME_SHARE_DATA);
        }
    }

    private void initView() {
        if (this.fIu == null) {
            this.fIu = new a(getActivity(), this);
        }
        setContentView(this.fIu.getRootView());
        this.fIu.a(this.fIv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e u(Bitmap bitmap) {
        e eVar = new e();
        eVar.n(bitmap);
        eVar.cle = false;
        eVar.cld = false;
        eVar.aqb();
        return eVar;
    }

    @Override // com.baidu.tieba.frs.gameshare.a.InterfaceC0313a
    public void v(final Bitmap bitmap) {
        if (bitmap != null) {
            TiebaStatic.log(new an("c10125").bT("obj_param1", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO).bT("obj_type", "4"));
            aa.a(new z<e>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.z
                /* renamed from: bqd */
                public e doInBackground() {
                    GameShareCardActivity.this.z(bitmap);
                    return GameShareCardActivity.this.u(bitmap);
                }
            }, new k<e>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.k
                /* renamed from: o */
                public void onReturnDataInUI(e eVar) {
                    GameShareCardActivity.this.dZO.e(eVar);
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.gameshare.a.InterfaceC0313a
    public void w(final Bitmap bitmap) {
        if (bitmap != null) {
            TiebaStatic.log(new an("c10125").bT("obj_param1", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO).bT("obj_type", "3"));
            aa.a(new z<e>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.z
                /* renamed from: bqd */
                public e doInBackground() {
                    GameShareCardActivity.this.z(bitmap);
                    return GameShareCardActivity.this.u(bitmap);
                }
            }, new k<e>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.k
                /* renamed from: o */
                public void onReturnDataInUI(e eVar) {
                    GameShareCardActivity.this.dZO.f(eVar);
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.gameshare.a.InterfaceC0313a
    public void x(final Bitmap bitmap) {
        if (bitmap != null) {
            TiebaStatic.log(new an("c10125").bT("obj_param1", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO).bT("obj_type", "9"));
            aa.a(new z<e>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.z
                /* renamed from: bqd */
                public e doInBackground() {
                    GameShareCardActivity.this.z(bitmap);
                    return GameShareCardActivity.this.u(bitmap);
                }
            }, new k<e>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.k
                /* renamed from: o */
                public void onReturnDataInUI(e eVar) {
                    GameShareCardActivity.this.dZO.g(eVar);
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.gameshare.a.InterfaceC0313a
    public void y(final Bitmap bitmap) {
        if (bitmap != null) {
            TiebaStatic.log(new an("c10125").bT("obj_param1", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO).bT("obj_type", "7"));
            aa.a(new z<e>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.z
                /* renamed from: bqd */
                public e doInBackground() {
                    GameShareCardActivity.this.z(bitmap);
                    return GameShareCardActivity.this.u(bitmap);
                }
            }, new k<e>() { // from class: com.baidu.tieba.frs.gameshare.GameShareCardActivity.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.k
                /* renamed from: o */
                public void onReturnDataInUI(e eVar) {
                    GameShareCardActivity.this.dZO.j(eVar);
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.gameshare.a.InterfaceC0313a
    public void onCancel() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fIu != null) {
            this.fIu.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.white_alpha40));
        paint.setTextSize(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.fontsize28));
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(TbadkCoreApplication.getInst().getResources().getString(R.string.game_share_slogon), bitmap.getWidth() / 2, this.fIu.bqf() + TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds50), paint);
        canvas.save(31);
        canvas.restore();
    }
}
