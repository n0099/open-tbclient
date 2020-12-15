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
    private HeadImageView gFI;
    private int gFh;
    private com.baidu.live.liveroom.middleware.a.e hDE;
    private RelativeLayout hDF;
    private ImageView hDG;
    private TextView hDH;
    private LinearLayout hDI;
    private LinearLayout hDJ;
    private TextView hDK;
    private TextView hDL;
    private TextView hDM;
    private TextView hDN;
    private TextView hDO;
    private TextView hDP;
    private TextView hDQ;
    private FrameLayout hDR;
    private TextView hDS;
    private FrameLayout hDT;
    private TbImageView hDU;
    private TextView hDV;
    private TextView hDW;
    private RelativeLayout hDX;
    private LinearLayout hDY;
    private TextView hDZ;
    private TextView hEa;
    private String hEd;
    private Context mContext;
    private AlaLiveInfoData mLiveInfo;
    private String mPortrait;
    private View rootView;
    private boolean hEb = false;
    private boolean hEc = false;
    private String hcY = null;
    private String otherParams = "";

    @Override // com.baidu.live.liveroom.middleware.i
    public void r(Activity activity) {
        this.mContext = activity;
        initUI();
    }

    @Override // com.baidu.live.liveroom.middleware.a.b
    public View a(w wVar, com.baidu.live.liveroom.middleware.a.e eVar, int i, String str, String str2, String str3) {
        this.mPortrait = str2;
        this.gFh = i;
        this.hcY = str;
        this.hDE = eVar;
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
        this.hDF = (RelativeLayout) this.rootView.findViewById(a.f.inner_layout);
        this.hDG = (ImageView) this.rootView.findViewById(a.f.imgClose);
        this.gFI = (HeadImageView) this.rootView.findViewById(a.f.avatar_imageView);
        this.hDH = (TextView) this.rootView.findViewById(a.f.username_textView);
        this.hDI = (LinearLayout) this.rootView.findViewById(a.f.endTitle_layout);
        this.hDJ = (LinearLayout) this.rootView.findViewById(a.f.achievement_layout);
        this.bhK = (TextView) this.rootView.findViewById(a.f.title_textView);
        this.hDK = (TextView) this.rootView.findViewById(a.f.tvLiveEndTitle);
        this.hDL = (TextView) this.rootView.findViewById(a.f.tvLiveEndSubTitle);
        this.hDM = (TextView) this.rootView.findViewById(a.f.tvLiveEndUseTime);
        this.hDN = (TextView) this.rootView.findViewById(a.f.tvLiveEndWatchNum);
        this.hDO = (TextView) this.rootView.findViewById(a.f.tvLiveEndNewFansNum);
        this.hDP = (TextView) this.rootView.findViewById(a.f.tvLiveEndGiverNum);
        this.hDQ = (TextView) this.rootView.findViewById(a.f.tvLiveEndNewCharmNum);
        this.hDR = (FrameLayout) this.rootView.findViewById(a.f.share_layout);
        this.hDS = (TextView) this.rootView.findViewById(a.f.share_textView);
        this.hDT = (FrameLayout) this.rootView.findViewById(a.f.qr_layout);
        this.hDU = (TbImageView) this.rootView.findViewById(a.f.qr_imageView);
        this.hDV = (TextView) this.rootView.findViewById(a.f.appName_textView);
        this.hDW = (TextView) this.rootView.findViewById(a.f.qrIntroduce_textView);
        this.hDX = (RelativeLayout) this.rootView.findViewById(a.f.userHead_layout);
        this.hDY = (LinearLayout) this.rootView.findViewById(a.f.official_qq_group_ll);
        this.hDZ = (TextView) this.rootView.findViewById(a.f.official_qq_group);
        this.hEa = (TextView) this.rootView.findViewById(a.f.copy_official_qq_group);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.hDI.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hDG.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.topMargin += UtilHelper.getStatusBarHeight();
                this.hDG.setLayoutParams(layoutParams);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hDX.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.topMargin += UtilHelper.getStatusBarHeight();
                this.hDX.setLayoutParams(layoutParams2);
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
            this.gFI.setIsRound(true);
            this.gFI.setDrawBorder(true);
            this.gFI.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.gFI.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.gFI.setAutoChangeStyle(false);
            if (TextUtils.isEmpty(this.mPortrait)) {
                this.gFI.setDefaultResource(a.e.pic_avatar_moren);
            } else if (!TextUtils.equals(this.gFI.getUrl(), this.mPortrait)) {
                this.gFI.startLoad(this.mPortrait, 12, false, false);
            }
            if (TextUtils.isEmpty(str) || "null".equals(str)) {
                str = this.mLiveInfo.getNameShow();
            }
            if (!TextUtils.isEmpty(str) && str.length() > 10) {
                str = str.substring(0, 8) + StringHelper.STRING_MORE;
            }
            this.hDH.setText(Html.fromHtml(String.format("亲爱的<font color='#fed500'>%s</font>，本次直播荣获称号", str)));
            String str3 = wVar.mLiveInfo.anchorTitle;
            this.bhK.setText((TextUtils.isEmpty(str3) || TextUtils.equals(str3, "null")) ? "" : "");
            this.hDK.setText(this.mContext.getResources().getString(a.h.live_over_name));
            if (!TextUtils.isEmpty(this.hcY)) {
                SkinManager.setViewTextColor(this.hDL, a.c.sdk_hk_gradient_color_start);
                this.hDL.setAlpha(0.7f);
                this.hDL.setText(this.hcY);
                this.hDL.setVisibility(0);
            } else if (this.gFh == 1) {
                SkinManager.setViewTextColor(this.hDL, a.c.sdk_hk_gradient_color_start);
                this.hDL.setAlpha(0.7f);
                String closeReason = this.mLiveInfo.getCloseReason();
                if (TextUtils.equals(closeReason, "0")) {
                    closeReason = "";
                }
                this.hDL.setText(closeReason);
                this.hDL.setVisibility(0);
                this.hDK.setText(this.mContext.getResources().getString(a.h.live_closed));
            } else if (this.gFh == 0) {
                this.hDL.setVisibility(8);
            }
            this.hDM.setText(StringUtils.translateSecondsToString2((int) this.mLiveInfo.getLiveDuration()));
            if (this.mLiveInfo.familyFansCount > 10000) {
                this.hDN.setText(j.numFormatOverWanNaForAudienceNum(this.mLiveInfo.familyFansCount));
            } else {
                this.hDN.setText(j.formatTosepara(this.mLiveInfo.familyFansCount));
            }
            this.hDO.setText(j.formatTosepara(this.mLiveInfo.newFansCount));
            this.hDP.setText(j.formatTosepara(this.mLiveInfo.rewardUserCount));
            this.hDQ.setText(j.formatTosepara(this.mLiveInfo.charm_count));
            this.hDG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.hDE != null) {
                        b.this.hDE.Pv();
                    }
                }
            });
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.hDS.setBackgroundResource(a.e.round_sharebtn_hk_bg_radius_12_n);
            } else {
                this.hDS.setBackgroundResource(a.e.sdk_round_btn_qm_bg_radius_40_n);
            }
            final String str4 = this.mLiveInfo.live_id + "";
            final String str5 = this.mLiveInfo.room_id + "";
            if (this.mLiveInfo.feed_id == null || TextUtils.equals(this.mLiveInfo.feed_id, "null")) {
                str2 = "";
            } else {
                str2 = this.mLiveInfo.feed_id;
            }
            this.hDS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.b.2
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
                    if (b.this.hDE != null) {
                        boolean z2 = !TextUtils.isEmpty(b.this.mLiveInfo.qrcodeDownloadUrl) && b.this.hEb;
                        try {
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(b.this.hEd) && (file = new File(b.this.hEd)) != null && file.exists()) {
                            if (file.isFile()) {
                                z = true;
                                if (z || b.this.hEc != z2) {
                                    b.this.hEd = b.this.oi(z2);
                                }
                                if (z2) {
                                    b.this.hEc = true;
                                }
                                if (TextUtils.isEmpty(b.this.hEd)) {
                                    b.this.hDE.im(b.this.hEd);
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
                        b.this.hEd = b.this.oi(z2);
                        if (z2) {
                        }
                        if (TextUtils.isEmpty(b.this.hEd)) {
                        }
                    }
                }
            });
            this.hDU.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.ala.liveroom.views.b.3
                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onComplete(String str6, boolean z) {
                    if (TextUtils.equals(str6, b.this.mLiveInfo.qrcodeDownloadUrl)) {
                        b.this.hEb = z;
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
            this.hDV.setText(str6);
            String nameShow = this.mLiveInfo.getNameShow();
            if (nameShow == null) {
                nameShow = "";
            }
            this.hDW.setText("长按二维码认识 " + nameShow);
            if (ckZ()) {
                this.hDY.setVisibility(0);
                this.hDZ.setText(this.mContext.getResources().getString(a.h.ala_live_end_official_qq_group) + " " + com.baidu.live.ae.a.RB().brA.aOv.aKf);
                this.hEa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.b.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        b.this.copyToClipboard(com.baidu.live.ae.a.RB().brA.aOv.aKf);
                        BdToast.makeText(b.this.mContext, b.this.mContext.getResources().getString(a.h.ala_live_end_copy_qq_to_clipboard)).setDuration(17).show();
                    }
                });
            } else {
                this.hDY.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.mLiveInfo.qrcodeDownloadUrl)) {
                this.hDU.startLoad(this.mLiveInfo.qrcodeDownloadUrl, 10, false);
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

    private boolean ckZ() {
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
        RelativeLayout relativeLayout = this.hDF;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
        Calendar.getInstance().add(5, 0);
        String charSequence = TextUtils.concat("screenshot_", simpleDateFormat.format(new Date()), ".jpg").toString();
        Bitmap createBitmap = Bitmap.createBitmap(relativeLayout.getWidth(), relativeLayout.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        this.hDG.setVisibility(8);
        this.hDI.setVisibility(8);
        this.hDJ.setVisibility(0);
        this.hDR.setVisibility(8);
        this.hDY.setVisibility(8);
        if (z) {
            this.hDT.setAlpha(1.0f);
        }
        relativeLayout.draw(canvas);
        this.hDG.setVisibility(0);
        this.hDI.setVisibility(0);
        this.hDJ.setVisibility(4);
        this.hDR.setVisibility(0);
        if (ckZ()) {
            this.hDY.setVisibility(0);
        }
        this.hDT.setAlpha(0.0f);
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
