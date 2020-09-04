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
import com.baidu.live.data.r;
import com.baidu.live.sdk.a;
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
import com.baidu.live.utils.i;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes7.dex */
public class b extends com.baidu.live.liveroom.middleware.a.a {
    private TextView aWR;
    private HeadImageView fRT;
    private int fRs;
    private TextView gKA;
    private TextView gKB;
    private TextView gKC;
    private TextView gKD;
    private FrameLayout gKE;
    private TextView gKF;
    private FrameLayout gKG;
    private TbImageView gKH;
    private TextView gKI;
    private TextView gKJ;
    private RelativeLayout gKK;
    private LinearLayout gKL;
    private TextView gKM;
    private TextView gKN;
    private String gKQ;
    private com.baidu.live.liveroom.middleware.a.e gKr;
    private RelativeLayout gKs;
    private ImageView gKt;
    private TextView gKu;
    private LinearLayout gKv;
    private LinearLayout gKw;
    private TextView gKx;
    private TextView gKy;
    private TextView gKz;
    private Context mContext;
    private AlaLiveInfoData mLiveInfo;
    private String mPortrait;
    private View rootView;
    private boolean gKO = false;
    private boolean gKP = false;
    private String gkp = null;
    private String otherParams = "";

    @Override // com.baidu.live.liveroom.middleware.i
    public void r(Activity activity) {
        this.mContext = activity;
        initUI();
    }

    @Override // com.baidu.live.liveroom.middleware.a.b
    public View a(r rVar, com.baidu.live.liveroom.middleware.a.e eVar, int i, String str, String str2, String str3) {
        this.mPortrait = str2;
        this.fRs = i;
        this.gkp = str;
        this.gKr = eVar;
        d(rVar, str3);
        return this.rootView;
    }

    @Override // com.baidu.live.liveroom.middleware.a.b
    public View a(r rVar, String str) {
        d(rVar, str);
        return this.rootView;
    }

    private void initUI() {
        this.rootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_live_end_view_layout, (ViewGroup) null);
        this.gKs = (RelativeLayout) this.rootView.findViewById(a.g.inner_layout);
        this.gKt = (ImageView) this.rootView.findViewById(a.g.imgClose);
        this.fRT = (HeadImageView) this.rootView.findViewById(a.g.avatar_imageView);
        this.gKu = (TextView) this.rootView.findViewById(a.g.username_textView);
        this.gKv = (LinearLayout) this.rootView.findViewById(a.g.endTitle_layout);
        this.gKw = (LinearLayout) this.rootView.findViewById(a.g.achievement_layout);
        this.aWR = (TextView) this.rootView.findViewById(a.g.title_textView);
        this.gKx = (TextView) this.rootView.findViewById(a.g.tvLiveEndTitle);
        this.gKy = (TextView) this.rootView.findViewById(a.g.tvLiveEndSubTitle);
        this.gKz = (TextView) this.rootView.findViewById(a.g.tvLiveEndUseTime);
        this.gKA = (TextView) this.rootView.findViewById(a.g.tvLiveEndWatchNum);
        this.gKB = (TextView) this.rootView.findViewById(a.g.tvLiveEndNewFansNum);
        this.gKC = (TextView) this.rootView.findViewById(a.g.tvLiveEndGiverNum);
        this.gKD = (TextView) this.rootView.findViewById(a.g.tvLiveEndNewCharmNum);
        this.gKE = (FrameLayout) this.rootView.findViewById(a.g.share_layout);
        this.gKF = (TextView) this.rootView.findViewById(a.g.share_textView);
        this.gKG = (FrameLayout) this.rootView.findViewById(a.g.qr_layout);
        this.gKH = (TbImageView) this.rootView.findViewById(a.g.qr_imageView);
        this.gKI = (TextView) this.rootView.findViewById(a.g.appName_textView);
        this.gKJ = (TextView) this.rootView.findViewById(a.g.qrIntroduce_textView);
        this.gKK = (RelativeLayout) this.rootView.findViewById(a.g.userHead_layout);
        this.gKL = (LinearLayout) this.rootView.findViewById(a.g.official_qq_group_ll);
        this.gKM = (TextView) this.rootView.findViewById(a.g.official_qq_group);
        this.gKN = (TextView) this.rootView.findViewById(a.g.copy_official_qq_group);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.gKv.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gKt.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.topMargin += UtilHelper.getStatusBarHeight();
                this.gKt.setLayoutParams(layoutParams);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gKK.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.topMargin += UtilHelper.getStatusBarHeight();
                this.gKK.setLayoutParams(layoutParams2);
            }
        }
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTER_CLOSE_LIVE_BEGIN);
            alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CLOSE_LIVE));
        }
    }

    private void d(r rVar, String str) {
        final String str2;
        if (rVar != null && rVar.mLiveInfo != null) {
            this.mLiveInfo = rVar.mLiveInfo;
            this.fRT.setIsRound(true);
            this.fRT.setDrawBorder(true);
            this.fRT.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.fRT.setAutoChangeStyle(false);
            if (TextUtils.isEmpty(this.mPortrait)) {
                this.fRT.setDefaultResource(a.f.pic_avatar_moren);
            } else if (!TextUtils.equals(this.fRT.getUrl(), this.mPortrait)) {
                this.fRT.startLoad(this.mPortrait, 12, false, false);
            }
            if (TextUtils.isEmpty(str) || "null".equals(str)) {
                str = this.mLiveInfo.getNameShow();
            }
            if (!TextUtils.isEmpty(str) && str.length() > 10) {
                str = str.substring(0, 8) + StringHelper.STRING_MORE;
            }
            this.gKu.setText(Html.fromHtml(String.format("亲爱的<font color='#fed500'>%s</font>，本次直播荣获称号", str)));
            String str3 = rVar.mLiveInfo.anchorTitle;
            this.aWR.setText((TextUtils.isEmpty(str3) || TextUtils.equals(str3, "null")) ? "" : "");
            this.gKx.setText(this.mContext.getResources().getString(a.i.live_over_name));
            if (!TextUtils.isEmpty(this.gkp)) {
                SkinManager.setViewTextColor(this.gKy, a.d.sdk_hk_gradient_color_start);
                this.gKy.setAlpha(0.7f);
                this.gKy.setText(this.gkp);
                this.gKy.setVisibility(0);
            } else if (this.fRs == 1) {
                SkinManager.setViewTextColor(this.gKy, a.d.sdk_hk_gradient_color_start);
                this.gKy.setAlpha(0.7f);
                String closeReason = this.mLiveInfo.getCloseReason();
                if (TextUtils.equals(closeReason, "0")) {
                    closeReason = "";
                }
                this.gKy.setText(closeReason);
                this.gKy.setVisibility(0);
                this.gKx.setText(this.mContext.getResources().getString(a.i.live_closed));
            } else if (this.fRs == 0) {
                this.gKy.setVisibility(8);
            }
            this.gKz.setText(StringUtils.translateSecondsToString2((int) this.mLiveInfo.getLiveDuration()));
            if (this.mLiveInfo.familyFansCount > 10000) {
                this.gKA.setText(i.numFormatOverWanNaForAudienceNum(this.mLiveInfo.familyFansCount));
            } else {
                this.gKA.setText(i.formatTosepara(this.mLiveInfo.familyFansCount));
            }
            this.gKB.setText(i.formatTosepara(this.mLiveInfo.newFansCount));
            this.gKC.setText(i.formatTosepara(this.mLiveInfo.rewardUserCount));
            this.gKD.setText(i.formatTosepara(this.mLiveInfo.charm_count));
            this.gKt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.gKr != null) {
                        b.this.gKr.Ll();
                    }
                }
            });
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gKF.setBackgroundResource(a.f.round_sharebtn_hk_bg_radius_12_n);
            } else {
                this.gKF.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_40_n);
            }
            final String str4 = this.mLiveInfo.live_id + "";
            final String str5 = this.mLiveInfo.room_id + "";
            if (this.mLiveInfo.feed_id == null || TextUtils.equals(this.mLiveInfo.feed_id, "null")) {
                str2 = "";
            } else {
                str2 = this.mLiveInfo.feed_id;
            }
            this.gKF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.b.2
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
                    if (b.this.gKr != null) {
                        boolean z2 = !TextUtils.isEmpty(b.this.mLiveInfo.qrcodeDownloadUrl) && b.this.gKO;
                        try {
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(b.this.gKQ) && (file = new File(b.this.gKQ)) != null && file.exists()) {
                            if (file.isFile()) {
                                z = true;
                                if (z || b.this.gKP != z2) {
                                    b.this.gKQ = b.this.mG(z2);
                                }
                                if (z2) {
                                    b.this.gKP = true;
                                }
                                if (TextUtils.isEmpty(b.this.gKQ)) {
                                    b.this.gKr.gX(b.this.gKQ);
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
                        b.this.gKQ = b.this.mG(z2);
                        if (z2) {
                        }
                        if (TextUtils.isEmpty(b.this.gKQ)) {
                        }
                    }
                }
            });
            this.gKH.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.ala.liveroom.views.b.3
                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onComplete(String str6, boolean z) {
                    if (TextUtils.equals(str6, b.this.mLiveInfo.qrcodeDownloadUrl)) {
                        b.this.gKO = z;
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
            this.gKI.setText(str6);
            String nameShow = this.mLiveInfo.getNameShow();
            if (nameShow == null) {
                nameShow = "";
            }
            this.gKJ.setText("长按二维码认识 " + nameShow);
            if (bWX()) {
                this.gKL.setVisibility(0);
                this.gKM.setText(this.mContext.getResources().getString(a.i.ala_live_end_official_qq_group) + " " + com.baidu.live.w.a.Nk().beJ.aHm.aDN);
                this.gKN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.b.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        b.this.copyToClipboard(com.baidu.live.w.a.Nk().beJ.aHm.aDN);
                        BdToast.makeText(b.this.mContext, b.this.mContext.getResources().getString(a.i.ala_live_end_copy_qq_to_clipboard)).setDuration(17).show();
                    }
                });
            } else {
                this.gKL.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.mLiveInfo.qrcodeDownloadUrl)) {
                this.gKH.startLoad(this.mLiveInfo.qrcodeDownloadUrl, 10, false);
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
    public void cb(boolean z) {
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    private boolean bWX() {
        return (com.baidu.live.w.a.Nk().beJ == null || com.baidu.live.w.a.Nk().beJ.aHm == null || TextUtils.isEmpty(com.baidu.live.w.a.Nk().beJ.aHm.aDN)) ? false : true;
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
    public String mG(boolean z) {
        String str;
        String str2;
        RelativeLayout relativeLayout = this.gKs;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
        Calendar.getInstance().add(5, 0);
        String charSequence = TextUtils.concat("screenshot_", simpleDateFormat.format(new Date()), ".jpg").toString();
        Bitmap createBitmap = Bitmap.createBitmap(relativeLayout.getWidth(), relativeLayout.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        this.gKt.setVisibility(8);
        this.gKv.setVisibility(8);
        this.gKw.setVisibility(0);
        this.gKE.setVisibility(8);
        this.gKL.setVisibility(8);
        if (z) {
            this.gKG.setAlpha(1.0f);
        }
        relativeLayout.draw(canvas);
        this.gKt.setVisibility(0);
        this.gKv.setVisibility(0);
        this.gKw.setVisibility(4);
        this.gKE.setVisibility(0);
        if (bWX()) {
            this.gKL.setVisibility(0);
        }
        this.gKG.setAlpha(0.0f);
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
            } catch (Throwable th) {
                if (createBitmap != null) {
                    try {
                        createBitmap.recycle();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e3) {
            e3.printStackTrace();
            if (createBitmap != null) {
                try {
                    createBitmap.recycle();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            return null;
        }
    }
}
