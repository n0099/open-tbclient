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
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import d.a.m0.z0.f0;
import d.a.m0.z0.h0;
import d.a.m0.z0.n;
import d.a.n0.r0.v1.a;
/* loaded from: classes4.dex */
public class GameShareCardActivity extends BaseActivity implements a.h {
    public GameShareData mShareData;
    public d.a.m0.s.g.g mShareTool;
    public d.a.n0.r0.v1.a mView;

    /* loaded from: classes4.dex */
    public class a extends f0<ShareItem> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Bitmap f15497a;

        public a(Bitmap bitmap) {
            this.f15497a = bitmap;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.z0.f0
        /* renamed from: a */
        public ShareItem doInBackground() {
            GameShareCardActivity.this.createWaterMark(this.f15497a);
            return GameShareCardActivity.this.generateShareItem(this.f15497a);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements n<ShareItem> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            GameShareCardActivity.this.mShareTool.m(shareItem);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends f0<ShareItem> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Bitmap f15500a;

        public c(Bitmap bitmap) {
            this.f15500a = bitmap;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.z0.f0
        /* renamed from: a */
        public ShareItem doInBackground() {
            GameShareCardActivity.this.createWaterMark(this.f15500a);
            return GameShareCardActivity.this.generateShareItem(this.f15500a);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements n<ShareItem> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            GameShareCardActivity.this.mShareTool.n(shareItem);
        }
    }

    /* loaded from: classes4.dex */
    public class e extends f0<ShareItem> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Bitmap f15503a;

        public e(Bitmap bitmap) {
            this.f15503a = bitmap;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.z0.f0
        /* renamed from: a */
        public ShareItem doInBackground() {
            GameShareCardActivity.this.createWaterMark(this.f15503a);
            return GameShareCardActivity.this.generateShareItem(this.f15503a);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements n<ShareItem> {
        public f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            GameShareCardActivity.this.mShareTool.h(shareItem);
        }
    }

    /* loaded from: classes4.dex */
    public class g extends f0<ShareItem> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Bitmap f15506a;

        public g(Bitmap bitmap) {
            this.f15506a = bitmap;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.z0.f0
        /* renamed from: a */
        public ShareItem doInBackground() {
            GameShareCardActivity.this.createWaterMark(this.f15506a);
            return GameShareCardActivity.this.generateShareItem(this.f15506a);
        }
    }

    /* loaded from: classes4.dex */
    public class h implements n<ShareItem> {
        public h() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            GameShareCardActivity.this.mShareTool.k(shareItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createWaterMark(Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.white_alpha40));
        paint.setTextSize(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.fontsize28));
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(TbadkCoreApplication.getInst().getResources().getString(R.string.game_share_slogon), bitmap.getWidth() / 2, this.mView.h() + TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds50), paint);
        canvas.save();
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ShareItem generateShareItem(Bitmap bitmap) {
        ShareItem shareItem = new ShareItem();
        shareItem.i(bitmap);
        shareItem.c0 = false;
        shareItem.b0 = false;
        shareItem.g();
        return shareItem;
    }

    private void initData(Bundle bundle) {
        if (this.mShareTool == null) {
            this.mShareTool = new d.a.m0.s.g.g(getActivity(), null);
        }
        if (bundle == null) {
            this.mShareData = (GameShareData) getIntent().getParcelableExtra(GameShareActivityConfig.KEY_GAME_SHARE_DATA);
        } else {
            this.mShareData = (GameShareData) bundle.getParcelable(GameShareActivityConfig.KEY_GAME_SHARE_DATA);
        }
    }

    private void initView() {
        if (this.mView == null) {
            this.mView = new d.a.n0.r0.v1.a(getActivity(), this);
        }
        setContentView(this.mView.i());
        this.mView.m(this.mShareData);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.pop_enter_anim, R.anim.pop_exit_anim);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 24007 && intent != null && intent.getIntExtra("extra_share_status", 2) == 1) {
            finish();
        }
    }

    @Override // d.a.n0.r0.v1.a.h
    public void onCancel() {
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        overridePendingTransition(R.anim.pop_enter_anim, R.anim.pop_exit_anim);
        initData(bundle);
        initView();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d.a.n0.r0.v1.a aVar = this.mView;
        if (aVar != null) {
            aVar.j();
        }
    }

    @Override // d.a.n0.r0.v1.a.h
    public void onQQShare(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", "8").param("obj_type", HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9));
        h0.b(new e(bitmap), new f());
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(GameShareActivityConfig.KEY_GAME_SHARE_DATA, this.mShareData);
    }

    @Override // d.a.n0.r0.v1.a.h
    public void onSinaShare(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", "8").param("obj_type", "7"));
        h0.b(new g(bitmap), new h());
    }

    @Override // d.a.n0.r0.v1.a.h
    public void onWeixinShare(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", "8").param("obj_type", "4"));
        h0.b(new a(bitmap), new b());
    }

    @Override // d.a.n0.r0.v1.a.h
    public void onWxFriendsShare(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", "8").param("obj_type", "3"));
        h0.b(new c(bitmap), new d());
    }
}
