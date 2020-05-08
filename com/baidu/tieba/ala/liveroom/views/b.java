package com.baidu.tieba.ala.liveroom.views;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Environment;
import android.text.ClipboardManager;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.n;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdToast;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
import com.baidu.live.utils.i;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class b extends com.baidu.live.liveroom.middleware.a.a {
    private TextView aHU;
    private com.baidu.live.liveroom.middleware.a.e fQY;
    private RelativeLayout fQZ;
    private ImageView fRa;
    private TextView fRb;
    private LinearLayout fRc;
    private LinearLayout fRd;
    private TextView fRe;
    private TextView fRf;
    private TextView fRg;
    private TextView fRh;
    private TextView fRi;
    private TextView fRj;
    private TextView fRk;
    private FrameLayout fRl;
    private TextView fRm;
    private FrameLayout fRn;
    private TbImageView fRo;
    private TextView fRp;
    private TextView fRq;
    private RelativeLayout fRr;
    private LinearLayout fRs;
    private TextView fRt;
    private TextView fRu;
    private String fRx;
    private int fbO;
    private HeadImageView fcp;
    private Context mContext;
    private AlaLiveInfoData mLiveInfo;
    private String mPortrait;
    private View rootView;
    private boolean fRv = false;
    private boolean fRw = false;
    private String ftE = null;
    private String otherParams = "";

    @Override // com.baidu.live.liveroom.middleware.i
    public void q(Activity activity) {
        this.mContext = activity;
        initUI();
    }

    @Override // com.baidu.live.liveroom.middleware.a.b
    public View a(n nVar, com.baidu.live.liveroom.middleware.a.e eVar, int i, String str, String str2, String str3) {
        this.mPortrait = str2;
        this.fbO = i;
        this.ftE = str;
        this.fQY = eVar;
        d(nVar, str3);
        return this.rootView;
    }

    @Override // com.baidu.live.liveroom.middleware.a.b
    public View b(n nVar, String str) {
        d(nVar, str);
        return this.rootView;
    }

    private void initUI() {
        this.rootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_live_end_view_layout, (ViewGroup) null);
        this.fQZ = (RelativeLayout) this.rootView.findViewById(a.g.inner_layout);
        this.fRa = (ImageView) this.rootView.findViewById(a.g.imgClose);
        this.fcp = (HeadImageView) this.rootView.findViewById(a.g.avatar_imageView);
        this.fRb = (TextView) this.rootView.findViewById(a.g.username_textView);
        this.fRc = (LinearLayout) this.rootView.findViewById(a.g.endTitle_layout);
        this.fRd = (LinearLayout) this.rootView.findViewById(a.g.achievement_layout);
        this.aHU = (TextView) this.rootView.findViewById(a.g.title_textView);
        this.fRe = (TextView) this.rootView.findViewById(a.g.tvLiveEndTitle);
        this.fRf = (TextView) this.rootView.findViewById(a.g.tvLiveEndSubTitle);
        this.fRg = (TextView) this.rootView.findViewById(a.g.tvLiveEndUseTime);
        this.fRh = (TextView) this.rootView.findViewById(a.g.tvLiveEndWatchNum);
        this.fRi = (TextView) this.rootView.findViewById(a.g.tvLiveEndNewFansNum);
        this.fRj = (TextView) this.rootView.findViewById(a.g.tvLiveEndGiverNum);
        this.fRk = (TextView) this.rootView.findViewById(a.g.tvLiveEndNewCharmNum);
        this.fRl = (FrameLayout) this.rootView.findViewById(a.g.share_layout);
        this.fRm = (TextView) this.rootView.findViewById(a.g.share_textView);
        this.fRn = (FrameLayout) this.rootView.findViewById(a.g.qr_layout);
        this.fRo = (TbImageView) this.rootView.findViewById(a.g.qr_imageView);
        this.fRp = (TextView) this.rootView.findViewById(a.g.appName_textView);
        this.fRq = (TextView) this.rootView.findViewById(a.g.qrIntroduce_textView);
        this.fRr = (RelativeLayout) this.rootView.findViewById(a.g.userHead_layout);
        this.fRs = (LinearLayout) this.rootView.findViewById(a.g.official_qq_group_ll);
        this.fRt = (TextView) this.rootView.findViewById(a.g.official_qq_group);
        this.fRu = (TextView) this.rootView.findViewById(a.g.copy_official_qq_group);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.fRc.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fRa.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.topMargin += UtilHelper.getStatusBarHeight();
                this.fRa.setLayoutParams(layoutParams);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fRr.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.topMargin += UtilHelper.getStatusBarHeight();
                this.fRr.setLayoutParams(layoutParams2);
            }
        }
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTER_CLOSE_LIVE_BEGIN);
            alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CLOSE_LIVE));
        }
    }

    private void d(n nVar, String str) {
        final String str2;
        if (nVar != null && nVar.mLiveInfo != null) {
            this.mLiveInfo = nVar.mLiveInfo;
            this.fcp.setIsRound(true);
            this.fcp.setDrawBorder(true);
            this.fcp.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.fcp.setAutoChangeStyle(false);
            if (TextUtils.isEmpty(this.mPortrait)) {
                this.fcp.setDefaultResource(a.f.pic_avatar_moren);
            } else {
                this.fcp.startLoad(this.mPortrait, 12, false, false);
            }
            if (TextUtils.isEmpty(str) || "null".equals(str)) {
                str = this.mLiveInfo.getNameShow();
            }
            if (!TextUtils.isEmpty(str) && str.length() > 10) {
                str = str.substring(0, 8) + StringHelper.STRING_MORE;
            }
            this.fRb.setText(Html.fromHtml(String.format("亲爱的<font color='#fed500'>%s</font>，本次直播荣获称号", str)));
            String str3 = nVar.mLiveInfo.anchorTitle;
            this.aHU.setText((TextUtils.isEmpty(str3) || TextUtils.equals(str3, "null")) ? "" : "");
            this.fRe.setText(this.mContext.getResources().getString(a.i.live_over_name));
            if (!TextUtils.isEmpty(this.ftE)) {
                SkinManager.setViewTextColor(this.fRf, a.d.sdk_hk_gradient_color_start);
                this.fRf.setAlpha(0.7f);
                this.fRf.setText(this.ftE);
                this.fRf.setVisibility(0);
            } else if (this.fbO == 1) {
                SkinManager.setViewTextColor(this.fRf, a.d.sdk_hk_gradient_color_start);
                this.fRf.setAlpha(0.7f);
                String closeReason = this.mLiveInfo.getCloseReason();
                if (TextUtils.equals(closeReason, "0")) {
                    closeReason = "";
                }
                this.fRf.setText(closeReason);
                this.fRf.setVisibility(0);
                this.fRe.setText(this.mContext.getResources().getString(a.i.live_closed));
            } else if (this.fbO == 0) {
                this.fRf.setVisibility(8);
            }
            this.fRg.setText(StringUtils.translateSecondsToString2((int) this.mLiveInfo.getLiveDuration()));
            if (this.mLiveInfo.familyFansCount > 10000) {
                this.fRh.setText(i.numFormatOverWanNaForAudienceNum(this.mLiveInfo.familyFansCount));
            } else {
                this.fRh.setText(i.formatTosepara(this.mLiveInfo.familyFansCount));
            }
            this.fRi.setText(i.formatTosepara(this.mLiveInfo.newFansCount));
            this.fRj.setText(i.formatTosepara(this.mLiveInfo.rewardUserCount));
            this.fRk.setText(i.formatTosepara(this.mLiveInfo.charm_count));
            this.fRa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.fQY != null) {
                        b.this.fQY.DD();
                    }
                }
            });
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.fRm.setBackgroundResource(a.f.round_sharebtn_hk_bg_radius_12_n);
            } else {
                this.fRm.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_40_n);
            }
            final String str4 = this.mLiveInfo.live_id + "";
            final String str5 = this.mLiveInfo.room_id + "";
            if (this.mLiveInfo.feed_id == null || TextUtils.equals(this.mLiveInfo.feed_id, "null")) {
                str2 = "";
            } else {
                str2 = this.mLiveInfo.feed_id;
            }
            this.fRm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.b.2
                /* JADX WARN: Removed duplicated region for block: B:23:0x0071  */
                /* JADX WARN: Removed duplicated region for block: B:26:0x0082  */
                /* JADX WARN: Removed duplicated region for block: B:32:0x0095  */
                @Override // android.view.View.OnClickListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onClick(View view) {
                    boolean z;
                    File file;
                    LogManager.getLiveCloseLogger().doClickShowOffLiveCloseLog(str4, str5, str2, b.this.otherParams);
                    if (b.this.fQY != null) {
                        boolean z2 = !TextUtils.isEmpty(b.this.mLiveInfo.qrcodeDownloadUrl) && b.this.fRv;
                        try {
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(b.this.fRx) && (file = new File(b.this.fRx)) != null && file.exists()) {
                            if (file.isFile()) {
                                z = true;
                                if (z || b.this.fRw != z2) {
                                    b.this.fRx = b.this.kT(z2);
                                }
                                if (z2) {
                                    b.this.fRw = true;
                                }
                                if (TextUtils.isEmpty(b.this.fRx)) {
                                    b.this.fQY.eL(b.this.fRx);
                                    return;
                                } else {
                                    BdUtilHelper.getCustomToast().showToast("分享失败", 0);
                                    return;
                                }
                            }
                        }
                        z = false;
                        if (z) {
                        }
                        b.this.fRx = b.this.kT(z2);
                        if (z2) {
                        }
                        if (TextUtils.isEmpty(b.this.fRx)) {
                        }
                    }
                }
            });
            this.fRo.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.ala.liveroom.views.b.3
                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onComplete(String str6, boolean z) {
                    if (TextUtils.equals(str6, b.this.mLiveInfo.qrcodeDownloadUrl)) {
                        b.this.fRv = z;
                    }
                }

                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onCancel() {
                }
            });
            String str6 = "";
            if (TbadkCoreApplication.getInst().isHaokan()) {
                str6 = "好看视频";
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                str6 = "全民小视频";
            } else if (TbadkCoreApplication.getInst().isTieba()) {
                str6 = "百度贴吧";
            }
            this.fRp.setText(str6);
            String nameShow = this.mLiveInfo.getNameShow();
            if (nameShow == null) {
                nameShow = "";
            }
            this.fRq.setText("长按二维码认识 " + nameShow);
            if (bAu()) {
                this.fRs.setVisibility(0);
                this.fRt.setText(this.mContext.getResources().getString(a.i.ala_live_end_official_qq_group) + " " + com.baidu.live.v.a.En().aQu.atA.aqr);
                this.fRu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.b.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        b.this.copyToClipboard(com.baidu.live.v.a.En().aQu.atA.aqr);
                        BdToast.makeText(b.this.mContext, b.this.mContext.getResources().getString(a.i.ala_live_end_copy_qq_to_clipboard)).setDuration(17).show();
                    }
                });
            } else {
                this.fRs.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.mLiveInfo.qrcodeDownloadUrl)) {
                this.fRo.startLoad(this.mLiveInfo.qrcodeDownloadUrl, 10, false);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913097, "into_end_view"));
        }
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public void onResume() {
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public void onPause() {
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public void onStop() {
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public void bI(boolean z) {
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    private boolean bAu() {
        return (com.baidu.live.v.a.En().aQu == null || com.baidu.live.v.a.En().aQu.atA == null || TextUtils.isEmpty(com.baidu.live.v.a.En().aQu.atA.aqr)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void copyToClipboard(String str) {
        if (str == null) {
            str = "";
        }
        try {
            ((ClipboardManager) BdBaseApplication.getInst().getApp().getSystemService("clipboard")).setText(str);
        } catch (Throwable th) {
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX INFO: Access modifiers changed from: private */
    public String kT(boolean z) {
        String str;
        String str2;
        RelativeLayout relativeLayout = this.fQZ;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
        Calendar.getInstance().add(5, 0);
        String charSequence = TextUtils.concat("screenshot_", simpleDateFormat.format(new Date()), ".jpg").toString();
        Bitmap createBitmap = Bitmap.createBitmap(relativeLayout.getWidth(), relativeLayout.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        this.fRa.setVisibility(8);
        this.fRc.setVisibility(8);
        this.fRd.setVisibility(0);
        this.fRl.setVisibility(8);
        this.fRs.setVisibility(8);
        if (z) {
            this.fRn.setVisibility(0);
        }
        relativeLayout.draw(canvas);
        this.fRa.setVisibility(0);
        this.fRc.setVisibility(0);
        this.fRd.setVisibility(4);
        this.fRl.setVisibility(0);
        if (bAu()) {
            this.fRs.setVisibility(0);
        }
        this.fRn.setVisibility(4);
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            str = "haokan";
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            str = TbadkCoreApplication.APP_ID_QUANMIN;
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            str = "tieba";
        } else {
            str = "baidu";
        }
        if (externalStoragePublicDirectory != null && externalStoragePublicDirectory.isDirectory()) {
            str2 = externalStoragePublicDirectory.getPath() + "/" + str + "/live/";
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
        } else if ("mounted".equals(Environment.getExternalStorageState())) {
            File file2 = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + str + "/live/");
            if (!file2.exists()) {
                file2.mkdirs();
            }
            str2 = file2.getPath();
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = this.mContext.getCacheDir().getPath();
        }
        Log.i("AlaLiveEndView", "@@ path=" + str2);
        File file3 = new File(str2, charSequence);
        try {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file3);
                createBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                String path = file3.getPath();
                Log.i("AlaLiveEndView", "@@ fullPath=" + path);
                Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                intent.setData(Uri.parse("file://" + path));
                this.mContext.sendBroadcast(intent);
                if (createBitmap != null) {
                    try {
                        createBitmap.recycle();
                        return path;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return path;
                    }
                }
                return path;
            } catch (IOException e2) {
                e2.printStackTrace();
                if (createBitmap != null) {
                    try {
                        createBitmap.recycle();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                return null;
            }
        } catch (Throwable th) {
            if (createBitmap != null) {
                try {
                    createBitmap.recycle();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }
}
