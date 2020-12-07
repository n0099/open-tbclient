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
import com.baidu.live.data.w;
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
/* loaded from: classes4.dex */
public class b extends com.baidu.live.liveroom.middleware.a.a {
    private TextView bhK;
    private HeadImageView gFG;
    private int gFf;
    private com.baidu.live.liveroom.middleware.a.e hDC;
    private RelativeLayout hDD;
    private ImageView hDE;
    private TextView hDF;
    private LinearLayout hDG;
    private LinearLayout hDH;
    private TextView hDI;
    private TextView hDJ;
    private TextView hDK;
    private TextView hDL;
    private TextView hDM;
    private TextView hDN;
    private TextView hDO;
    private FrameLayout hDP;
    private TextView hDQ;
    private FrameLayout hDR;
    private TbImageView hDS;
    private TextView hDT;
    private TextView hDU;
    private RelativeLayout hDV;
    private LinearLayout hDW;
    private TextView hDX;
    private TextView hDY;
    private String hEb;
    private Context mContext;
    private AlaLiveInfoData mLiveInfo;
    private String mPortrait;
    private View rootView;
    private boolean hDZ = false;
    private boolean hEa = false;
    private String hcW = null;
    private String otherParams = "";

    @Override // com.baidu.live.liveroom.middleware.i
    public void r(Activity activity) {
        this.mContext = activity;
        initUI();
    }

    @Override // com.baidu.live.liveroom.middleware.a.b
    public View a(w wVar, com.baidu.live.liveroom.middleware.a.e eVar, int i, String str, String str2, String str3) {
        this.mPortrait = str2;
        this.gFf = i;
        this.hcW = str;
        this.hDC = eVar;
        d(wVar, str3);
        return this.rootView;
    }

    @Override // com.baidu.live.liveroom.middleware.a.b
    public View a(w wVar, String str) {
        d(wVar, str);
        return this.rootView;
    }

    private void initUI() {
        this.rootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_live_end_view_layout, (ViewGroup) null);
        this.hDD = (RelativeLayout) this.rootView.findViewById(a.f.inner_layout);
        this.hDE = (ImageView) this.rootView.findViewById(a.f.imgClose);
        this.gFG = (HeadImageView) this.rootView.findViewById(a.f.avatar_imageView);
        this.hDF = (TextView) this.rootView.findViewById(a.f.username_textView);
        this.hDG = (LinearLayout) this.rootView.findViewById(a.f.endTitle_layout);
        this.hDH = (LinearLayout) this.rootView.findViewById(a.f.achievement_layout);
        this.bhK = (TextView) this.rootView.findViewById(a.f.title_textView);
        this.hDI = (TextView) this.rootView.findViewById(a.f.tvLiveEndTitle);
        this.hDJ = (TextView) this.rootView.findViewById(a.f.tvLiveEndSubTitle);
        this.hDK = (TextView) this.rootView.findViewById(a.f.tvLiveEndUseTime);
        this.hDL = (TextView) this.rootView.findViewById(a.f.tvLiveEndWatchNum);
        this.hDM = (TextView) this.rootView.findViewById(a.f.tvLiveEndNewFansNum);
        this.hDN = (TextView) this.rootView.findViewById(a.f.tvLiveEndGiverNum);
        this.hDO = (TextView) this.rootView.findViewById(a.f.tvLiveEndNewCharmNum);
        this.hDP = (FrameLayout) this.rootView.findViewById(a.f.share_layout);
        this.hDQ = (TextView) this.rootView.findViewById(a.f.share_textView);
        this.hDR = (FrameLayout) this.rootView.findViewById(a.f.qr_layout);
        this.hDS = (TbImageView) this.rootView.findViewById(a.f.qr_imageView);
        this.hDT = (TextView) this.rootView.findViewById(a.f.appName_textView);
        this.hDU = (TextView) this.rootView.findViewById(a.f.qrIntroduce_textView);
        this.hDV = (RelativeLayout) this.rootView.findViewById(a.f.userHead_layout);
        this.hDW = (LinearLayout) this.rootView.findViewById(a.f.official_qq_group_ll);
        this.hDX = (TextView) this.rootView.findViewById(a.f.official_qq_group);
        this.hDY = (TextView) this.rootView.findViewById(a.f.copy_official_qq_group);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.hDG.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hDE.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.topMargin += UtilHelper.getStatusBarHeight();
                this.hDE.setLayoutParams(layoutParams);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hDV.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.topMargin += UtilHelper.getStatusBarHeight();
                this.hDV.setLayoutParams(layoutParams2);
            }
        }
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTER_CLOSE_LIVE_BEGIN);
            alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CLOSE_LIVE));
        }
    }

    private void d(w wVar, String str) {
        final String str2;
        if (wVar != null && wVar.mLiveInfo != null) {
            this.mLiveInfo = wVar.mLiveInfo;
            this.gFG.setIsRound(true);
            this.gFG.setDrawBorder(true);
            this.gFG.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.gFG.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.gFG.setAutoChangeStyle(false);
            if (TextUtils.isEmpty(this.mPortrait)) {
                this.gFG.setDefaultResource(a.e.pic_avatar_moren);
            } else if (!TextUtils.equals(this.gFG.getUrl(), this.mPortrait)) {
                this.gFG.startLoad(this.mPortrait, 12, false, false);
            }
            if (TextUtils.isEmpty(str) || "null".equals(str)) {
                str = this.mLiveInfo.getNameShow();
            }
            if (!TextUtils.isEmpty(str) && str.length() > 10) {
                str = str.substring(0, 8) + StringHelper.STRING_MORE;
            }
            this.hDF.setText(Html.fromHtml(String.format("亲爱的<font color='#fed500'>%s</font>，本次直播荣获称号", str)));
            String str3 = wVar.mLiveInfo.anchorTitle;
            this.bhK.setText((TextUtils.isEmpty(str3) || TextUtils.equals(str3, "null")) ? "" : "");
            this.hDI.setText(this.mContext.getResources().getString(a.h.live_over_name));
            if (!TextUtils.isEmpty(this.hcW)) {
                SkinManager.setViewTextColor(this.hDJ, a.c.sdk_hk_gradient_color_start);
                this.hDJ.setAlpha(0.7f);
                this.hDJ.setText(this.hcW);
                this.hDJ.setVisibility(0);
            } else if (this.gFf == 1) {
                SkinManager.setViewTextColor(this.hDJ, a.c.sdk_hk_gradient_color_start);
                this.hDJ.setAlpha(0.7f);
                String closeReason = this.mLiveInfo.getCloseReason();
                if (TextUtils.equals(closeReason, "0")) {
                    closeReason = "";
                }
                this.hDJ.setText(closeReason);
                this.hDJ.setVisibility(0);
                this.hDI.setText(this.mContext.getResources().getString(a.h.live_closed));
            } else if (this.gFf == 0) {
                this.hDJ.setVisibility(8);
            }
            this.hDK.setText(StringUtils.translateSecondsToString2((int) this.mLiveInfo.getLiveDuration()));
            if (this.mLiveInfo.familyFansCount > 10000) {
                this.hDL.setText(j.numFormatOverWanNaForAudienceNum(this.mLiveInfo.familyFansCount));
            } else {
                this.hDL.setText(j.formatTosepara(this.mLiveInfo.familyFansCount));
            }
            this.hDM.setText(j.formatTosepara(this.mLiveInfo.newFansCount));
            this.hDN.setText(j.formatTosepara(this.mLiveInfo.rewardUserCount));
            this.hDO.setText(j.formatTosepara(this.mLiveInfo.charm_count));
            this.hDE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.hDC != null) {
                        b.this.hDC.Pv();
                    }
                }
            });
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.hDQ.setBackgroundResource(a.e.round_sharebtn_hk_bg_radius_12_n);
            } else {
                this.hDQ.setBackgroundResource(a.e.sdk_round_btn_qm_bg_radius_40_n);
            }
            final String str4 = this.mLiveInfo.live_id + "";
            final String str5 = this.mLiveInfo.room_id + "";
            if (this.mLiveInfo.feed_id == null || TextUtils.equals(this.mLiveInfo.feed_id, "null")) {
                str2 = "";
            } else {
                str2 = this.mLiveInfo.feed_id;
            }
            this.hDQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.b.2
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
                    if (b.this.hDC != null) {
                        boolean z2 = !TextUtils.isEmpty(b.this.mLiveInfo.qrcodeDownloadUrl) && b.this.hDZ;
                        try {
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(b.this.hEb) && (file = new File(b.this.hEb)) != null && file.exists()) {
                            if (file.isFile()) {
                                z = true;
                                if (z || b.this.hEa != z2) {
                                    b.this.hEb = b.this.oi(z2);
                                }
                                if (z2) {
                                    b.this.hEa = true;
                                }
                                if (TextUtils.isEmpty(b.this.hEb)) {
                                    b.this.hDC.im(b.this.hEb);
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
                        b.this.hEb = b.this.oi(z2);
                        if (z2) {
                        }
                        if (TextUtils.isEmpty(b.this.hEb)) {
                        }
                    }
                }
            });
            this.hDS.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.ala.liveroom.views.b.3
                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onComplete(String str6, boolean z) {
                    if (TextUtils.equals(str6, b.this.mLiveInfo.qrcodeDownloadUrl)) {
                        b.this.hDZ = z;
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
            this.hDT.setText(str6);
            String nameShow = this.mLiveInfo.getNameShow();
            if (nameShow == null) {
                nameShow = "";
            }
            this.hDU.setText("长按二维码认识 " + nameShow);
            if (ckY()) {
                this.hDW.setVisibility(0);
                this.hDX.setText(this.mContext.getResources().getString(a.h.ala_live_end_official_qq_group) + " " + com.baidu.live.ae.a.RB().brA.aOv.aKf);
                this.hDY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.b.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        b.this.copyToClipboard(com.baidu.live.ae.a.RB().brA.aOv.aKf);
                        BdToast.makeText(b.this.mContext, b.this.mContext.getResources().getString(a.h.ala_live_end_copy_qq_to_clipboard)).setDuration(17).show();
                    }
                });
            } else {
                this.hDW.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.mLiveInfo.qrcodeDownloadUrl)) {
                this.hDS.startLoad(this.mLiveInfo.qrcodeDownloadUrl, 10, false);
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
    public void cx(boolean z) {
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    private boolean ckY() {
        return (com.baidu.live.ae.a.RB().brA == null || com.baidu.live.ae.a.RB().brA.aOv == null || TextUtils.isEmpty(com.baidu.live.ae.a.RB().brA.aOv.aKf)) ? false : true;
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
    public String oi(boolean z) {
        String str;
        String str2;
        RelativeLayout relativeLayout = this.hDD;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
        Calendar.getInstance().add(5, 0);
        String charSequence = TextUtils.concat("screenshot_", simpleDateFormat.format(new Date()), ".jpg").toString();
        Bitmap createBitmap = Bitmap.createBitmap(relativeLayout.getWidth(), relativeLayout.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        this.hDE.setVisibility(8);
        this.hDG.setVisibility(8);
        this.hDH.setVisibility(0);
        this.hDP.setVisibility(8);
        this.hDW.setVisibility(8);
        if (z) {
            this.hDR.setAlpha(1.0f);
        }
        relativeLayout.draw(canvas);
        this.hDE.setVisibility(0);
        this.hDG.setVisibility(0);
        this.hDH.setVisibility(4);
        this.hDP.setVisibility(0);
        if (ckY()) {
            this.hDW.setVisibility(0);
        }
        this.hDR.setAlpha(0.0f);
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
