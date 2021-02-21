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
import com.baidu.live.data.ab;
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
import com.baidu.live.utils.j;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes11.dex */
public class b extends com.baidu.live.liveroom.middleware.a.a {
    private TextView bhK;
    private HeadImageView gPH;
    private int gPg;
    private com.baidu.live.liveroom.middleware.a.e hPG;
    private RelativeLayout hPH;
    private ImageView hPI;
    private TextView hPJ;
    private LinearLayout hPK;
    private LinearLayout hPL;
    private TextView hPM;
    private TextView hPN;
    private TextView hPO;
    private TextView hPP;
    private TextView hPQ;
    private TextView hPR;
    private TextView hPS;
    private FrameLayout hPT;
    private TextView hPU;
    private FrameLayout hPV;
    private TbImageView hPW;
    private TextView hPX;
    private TextView hPY;
    private RelativeLayout hPZ;
    private LinearLayout hQa;
    private TextView hQb;
    private TextView hQc;
    private String hQf;
    private Context mContext;
    private AlaLiveInfoData mLiveInfo;
    private String mPortrait;
    private View rootView;
    private boolean hQd = false;
    private boolean hQe = false;
    private String hoK = null;
    private String otherParams = "";

    @Override // com.baidu.live.liveroom.middleware.i
    public void q(Activity activity) {
        this.mContext = activity;
        initUI();
    }

    @Override // com.baidu.live.liveroom.middleware.a.b
    public View a(ab abVar, com.baidu.live.liveroom.middleware.a.e eVar, int i, String str, String str2, String str3) {
        this.mPortrait = str2;
        this.gPg = i;
        this.hoK = str;
        this.hPG = eVar;
        c(abVar, str3, 0);
        return this.rootView;
    }

    @Override // com.baidu.live.liveroom.middleware.a.b
    public View a(ab abVar, String str) {
        c(abVar, str, 1);
        return this.rootView;
    }

    private void initUI() {
        this.rootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_live_end_view_layout, (ViewGroup) null);
        this.hPH = (RelativeLayout) this.rootView.findViewById(a.f.inner_layout);
        this.hPI = (ImageView) this.rootView.findViewById(a.f.imgClose);
        this.gPH = (HeadImageView) this.rootView.findViewById(a.f.avatar_imageView);
        this.hPJ = (TextView) this.rootView.findViewById(a.f.username_textView);
        this.hPK = (LinearLayout) this.rootView.findViewById(a.f.endTitle_layout);
        this.hPL = (LinearLayout) this.rootView.findViewById(a.f.achievement_layout);
        this.bhK = (TextView) this.rootView.findViewById(a.f.title_textView);
        this.hPM = (TextView) this.rootView.findViewById(a.f.tvLiveEndTitle);
        this.hPN = (TextView) this.rootView.findViewById(a.f.tvLiveEndSubTitle);
        this.hPO = (TextView) this.rootView.findViewById(a.f.tvLiveEndUseTime);
        this.hPP = (TextView) this.rootView.findViewById(a.f.tvLiveEndWatchNum);
        this.hPQ = (TextView) this.rootView.findViewById(a.f.tvLiveEndNewFansNum);
        this.hPR = (TextView) this.rootView.findViewById(a.f.tvLiveEndGiverNum);
        this.hPS = (TextView) this.rootView.findViewById(a.f.tvLiveEndNewCharmNum);
        this.hPT = (FrameLayout) this.rootView.findViewById(a.f.share_layout);
        this.hPU = (TextView) this.rootView.findViewById(a.f.share_textView);
        this.hPV = (FrameLayout) this.rootView.findViewById(a.f.qr_layout);
        this.hPW = (TbImageView) this.rootView.findViewById(a.f.qr_imageView);
        this.hPX = (TextView) this.rootView.findViewById(a.f.appName_textView);
        this.hPY = (TextView) this.rootView.findViewById(a.f.qrIntroduce_textView);
        this.hPZ = (RelativeLayout) this.rootView.findViewById(a.f.userHead_layout);
        this.hQa = (LinearLayout) this.rootView.findViewById(a.f.official_qq_group_ll);
        this.hQb = (TextView) this.rootView.findViewById(a.f.official_qq_group);
        this.hQc = (TextView) this.rootView.findViewById(a.f.copy_official_qq_group);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.hPK.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hPI.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.topMargin += UtilHelper.getStatusBarHeight();
                this.hPI.setLayoutParams(layoutParams);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hPZ.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.topMargin += UtilHelper.getStatusBarHeight();
                this.hPZ.setLayoutParams(layoutParams2);
            }
        }
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTER_CLOSE_LIVE_BEGIN);
            alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CLOSE_LIVE));
        }
    }

    private void c(ab abVar, String str, int i) {
        final String str2;
        if (abVar != null && abVar.mLiveInfo != null) {
            this.mLiveInfo = abVar.mLiveInfo;
            this.gPH.setIsRound(true);
            this.gPH.setDrawBorder(true);
            this.gPH.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.gPH.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.gPH.setAutoChangeStyle(false);
            if (TextUtils.isEmpty(this.mPortrait)) {
                this.gPH.setDefaultResource(a.e.pic_avatar_moren);
            } else if (!TextUtils.equals(this.gPH.getUrl(), this.mPortrait)) {
                this.gPH.startLoad(this.mPortrait, 12, false, false);
            }
            if (TextUtils.isEmpty(str) || "null".equals(str)) {
                str = this.mLiveInfo.getNameShow();
            }
            if (!TextUtils.isEmpty(str) && str.length() > 10) {
                str = str.substring(0, 8) + StringHelper.STRING_MORE;
            }
            this.hPJ.setText(Html.fromHtml(String.format("亲爱的<font color='#fed500'>%s</font>，本次直播荣获称号", str)));
            String str3 = abVar.mLiveInfo.anchorTitle;
            this.bhK.setText((TextUtils.isEmpty(str3) || TextUtils.equals(str3, "null")) ? "" : "");
            this.hPM.setText(this.mContext.getResources().getString(a.h.live_over_name));
            if (!TextUtils.isEmpty(this.hoK)) {
                SkinManager.setViewTextColor(this.hPN, a.c.sdk_hk_gradient_color_start);
                this.hPN.setAlpha(0.7f);
                this.hPN.setText(this.hoK);
                this.hPN.setVisibility(0);
            } else if (this.gPg == 1) {
                SkinManager.setViewTextColor(this.hPN, a.c.sdk_hk_gradient_color_start);
                this.hPN.setAlpha(0.7f);
                String closeReason = this.mLiveInfo.getCloseReason();
                if (TextUtils.equals(closeReason, "0")) {
                    closeReason = "";
                }
                this.hPN.setText(closeReason);
                this.hPN.setVisibility(0);
                this.hPM.setText(this.mContext.getResources().getString(a.h.live_closed));
            } else if (this.gPg == 0) {
                this.hPN.setVisibility(8);
            }
            if (i == 0) {
                this.hPO.setText("");
                this.hPP.setText("");
                this.hPQ.setText("");
                this.hPR.setText("");
                this.hPS.setText("");
            }
            if (i == 1) {
                this.hPO.setText(StringUtils.translateSecondsToString2((int) this.mLiveInfo.getLiveDuration()));
                if (this.mLiveInfo.familyFansCount > 10000) {
                    this.hPP.setText(j.numFormatOverWanNaForAudienceNum(this.mLiveInfo.familyFansCount));
                } else {
                    this.hPP.setText(j.formatTosepara(this.mLiveInfo.familyFansCount));
                }
                this.hPQ.setText(j.formatTosepara(this.mLiveInfo.newFansCount));
                this.hPR.setText(j.formatTosepara(this.mLiveInfo.rewardUserCount));
                this.hPS.setText(j.formatTosepara(this.mLiveInfo.charm_count));
            }
            this.hPI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.hPG != null) {
                        b.this.hPG.MM();
                    }
                }
            });
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.hPU.setBackgroundResource(a.e.round_sharebtn_hk_bg_radius_12_n);
            } else {
                this.hPU.setBackgroundResource(a.e.sdk_round_btn_bg_radius_40_n);
            }
            final String str4 = this.mLiveInfo.live_id + "";
            final String str5 = this.mLiveInfo.room_id + "";
            if (this.mLiveInfo.feed_id == null || TextUtils.equals(this.mLiveInfo.feed_id, "null")) {
                str2 = "";
            } else {
                str2 = this.mLiveInfo.feed_id;
            }
            this.hPU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.b.2
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
                    if (b.this.hPG != null) {
                        boolean z2 = !TextUtils.isEmpty(b.this.mLiveInfo.qrcodeDownloadUrl) && b.this.hQd;
                        try {
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(b.this.hQf) && (file = new File(b.this.hQf)) != null && file.exists()) {
                            if (file.isFile()) {
                                z = true;
                                if (z || b.this.hQe != z2) {
                                    b.this.hQf = b.this.oN(z2);
                                }
                                if (z2) {
                                    b.this.hQe = true;
                                }
                                if (TextUtils.isEmpty(b.this.hQf)) {
                                    b.this.hPG.hm(b.this.hQf);
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
                        b.this.hQf = b.this.oN(z2);
                        if (z2) {
                        }
                        if (TextUtils.isEmpty(b.this.hQf)) {
                        }
                    }
                }
            });
            this.hPW.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.ala.liveroom.views.b.3
                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onComplete(String str6, boolean z) {
                    if (TextUtils.equals(str6, b.this.mLiveInfo.qrcodeDownloadUrl)) {
                        b.this.hQd = z;
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
            } else if (TbadkCoreApplication.getInst().isYinbo()) {
                str6 = "音啵";
            }
            this.hPX.setText(str6);
            String nameShow = this.mLiveInfo.getNameShow();
            if (nameShow == null) {
                nameShow = "";
            }
            this.hPY.setText("长按二维码认识 " + nameShow);
            if (cle()) {
                this.hQa.setVisibility(0);
                this.hQb.setText(this.mContext.getResources().getString(a.h.ala_live_end_official_qq_group) + " " + com.baidu.live.ae.a.Qj().buX.aNc.aIn);
                this.hQc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.b.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        b.this.copyToClipboard(com.baidu.live.ae.a.Qj().buX.aNc.aIn);
                        BdToast.makeText(b.this.mContext, b.this.mContext.getResources().getString(a.h.ala_live_end_copy_qq_to_clipboard)).setDuration(17).show();
                    }
                });
            } else {
                this.hQa.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.mLiveInfo.qrcodeDownloadUrl)) {
                this.hPW.startLoad(this.mLiveInfo.qrcodeDownloadUrl, 10, false);
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
    public void cF(boolean z) {
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    private boolean cle() {
        return (com.baidu.live.ae.a.Qj().buX == null || com.baidu.live.ae.a.Qj().buX.aNc == null || TextUtils.isEmpty(com.baidu.live.ae.a.Qj().buX.aNc.aIn)) ? false : true;
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
    public String oN(boolean z) {
        String str;
        String str2;
        RelativeLayout relativeLayout = this.hPH;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
        Calendar.getInstance().add(5, 0);
        String charSequence = TextUtils.concat("screenshot_", simpleDateFormat.format(new Date()), ".jpg").toString();
        Bitmap createBitmap = Bitmap.createBitmap(relativeLayout.getWidth(), relativeLayout.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        this.hPI.setVisibility(8);
        this.hPK.setVisibility(8);
        this.hPL.setVisibility(0);
        this.hPT.setVisibility(8);
        this.hQa.setVisibility(8);
        if (z) {
            this.hPV.setAlpha(1.0f);
        }
        relativeLayout.draw(canvas);
        this.hPI.setVisibility(0);
        this.hPK.setVisibility(0);
        this.hPL.setVisibility(4);
        this.hPT.setVisibility(0);
        if (cle()) {
            this.hQa.setVisibility(0);
        }
        this.hPV.setAlpha(0.0f);
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            str = "haokan";
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            str = TbadkCoreApplication.APP_ID_QUANMIN;
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            str = "tieba";
        } else if (TbadkCoreApplication.getInst().isYinbo()) {
            str = TbadkCoreApplication.APP_ID_YINBO;
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
