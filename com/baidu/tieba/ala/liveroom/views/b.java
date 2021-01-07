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
import com.baidu.live.data.x;
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
    private TextView bjt;
    private int gQS;
    private HeadImageView gRt;
    private com.baidu.live.liveroom.middleware.a.e hPE;
    private RelativeLayout hPF;
    private ImageView hPG;
    private TextView hPH;
    private LinearLayout hPI;
    private LinearLayout hPJ;
    private TextView hPK;
    private TextView hPL;
    private TextView hPM;
    private TextView hPN;
    private TextView hPO;
    private TextView hPP;
    private TextView hPQ;
    private FrameLayout hPR;
    private TextView hPS;
    private FrameLayout hPT;
    private TbImageView hPU;
    private TextView hPV;
    private TextView hPW;
    private RelativeLayout hPX;
    private LinearLayout hPY;
    private TextView hPZ;
    private TextView hQa;
    private String hQd;
    private Context mContext;
    private AlaLiveInfoData mLiveInfo;
    private String mPortrait;
    private View rootView;
    private boolean hQb = false;
    private boolean hQc = false;
    private String hoL = null;
    private String otherParams = "";

    @Override // com.baidu.live.liveroom.middleware.i
    public void q(Activity activity) {
        this.mContext = activity;
        initUI();
    }

    @Override // com.baidu.live.liveroom.middleware.a.b
    public View a(x xVar, com.baidu.live.liveroom.middleware.a.e eVar, int i, String str, String str2, String str3) {
        this.mPortrait = str2;
        this.gQS = i;
        this.hoL = str;
        this.hPE = eVar;
        d(xVar, str3);
        return this.rootView;
    }

    @Override // com.baidu.live.liveroom.middleware.a.b
    public View a(x xVar, String str) {
        d(xVar, str);
        return this.rootView;
    }

    private void initUI() {
        this.rootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_live_end_view_layout, (ViewGroup) null);
        this.hPF = (RelativeLayout) this.rootView.findViewById(a.f.inner_layout);
        this.hPG = (ImageView) this.rootView.findViewById(a.f.imgClose);
        this.gRt = (HeadImageView) this.rootView.findViewById(a.f.avatar_imageView);
        this.hPH = (TextView) this.rootView.findViewById(a.f.username_textView);
        this.hPI = (LinearLayout) this.rootView.findViewById(a.f.endTitle_layout);
        this.hPJ = (LinearLayout) this.rootView.findViewById(a.f.achievement_layout);
        this.bjt = (TextView) this.rootView.findViewById(a.f.title_textView);
        this.hPK = (TextView) this.rootView.findViewById(a.f.tvLiveEndTitle);
        this.hPL = (TextView) this.rootView.findViewById(a.f.tvLiveEndSubTitle);
        this.hPM = (TextView) this.rootView.findViewById(a.f.tvLiveEndUseTime);
        this.hPN = (TextView) this.rootView.findViewById(a.f.tvLiveEndWatchNum);
        this.hPO = (TextView) this.rootView.findViewById(a.f.tvLiveEndNewFansNum);
        this.hPP = (TextView) this.rootView.findViewById(a.f.tvLiveEndGiverNum);
        this.hPQ = (TextView) this.rootView.findViewById(a.f.tvLiveEndNewCharmNum);
        this.hPR = (FrameLayout) this.rootView.findViewById(a.f.share_layout);
        this.hPS = (TextView) this.rootView.findViewById(a.f.share_textView);
        this.hPT = (FrameLayout) this.rootView.findViewById(a.f.qr_layout);
        this.hPU = (TbImageView) this.rootView.findViewById(a.f.qr_imageView);
        this.hPV = (TextView) this.rootView.findViewById(a.f.appName_textView);
        this.hPW = (TextView) this.rootView.findViewById(a.f.qrIntroduce_textView);
        this.hPX = (RelativeLayout) this.rootView.findViewById(a.f.userHead_layout);
        this.hPY = (LinearLayout) this.rootView.findViewById(a.f.official_qq_group_ll);
        this.hPZ = (TextView) this.rootView.findViewById(a.f.official_qq_group);
        this.hQa = (TextView) this.rootView.findViewById(a.f.copy_official_qq_group);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.hPI.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hPG.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.topMargin += UtilHelper.getStatusBarHeight();
                this.hPG.setLayoutParams(layoutParams);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hPX.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.topMargin += UtilHelper.getStatusBarHeight();
                this.hPX.setLayoutParams(layoutParams2);
            }
        }
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTER_CLOSE_LIVE_BEGIN);
            alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CLOSE_LIVE));
        }
    }

    private void d(x xVar, String str) {
        final String str2;
        if (xVar != null && xVar.mLiveInfo != null) {
            this.mLiveInfo = xVar.mLiveInfo;
            this.gRt.setIsRound(true);
            this.gRt.setDrawBorder(true);
            this.gRt.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.gRt.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.gRt.setAutoChangeStyle(false);
            if (TextUtils.isEmpty(this.mPortrait)) {
                this.gRt.setDefaultResource(a.e.pic_avatar_moren);
            } else if (!TextUtils.equals(this.gRt.getUrl(), this.mPortrait)) {
                this.gRt.startLoad(this.mPortrait, 12, false, false);
            }
            if (TextUtils.isEmpty(str) || "null".equals(str)) {
                str = this.mLiveInfo.getNameShow();
            }
            if (!TextUtils.isEmpty(str) && str.length() > 10) {
                str = str.substring(0, 8) + StringHelper.STRING_MORE;
            }
            this.hPH.setText(Html.fromHtml(String.format("亲爱的<font color='#fed500'>%s</font>，本次直播荣获称号", str)));
            String str3 = xVar.mLiveInfo.anchorTitle;
            this.bjt.setText((TextUtils.isEmpty(str3) || TextUtils.equals(str3, "null")) ? "" : "");
            this.hPK.setText(this.mContext.getResources().getString(a.h.live_over_name));
            if (!TextUtils.isEmpty(this.hoL)) {
                SkinManager.setViewTextColor(this.hPL, a.c.sdk_hk_gradient_color_start);
                this.hPL.setAlpha(0.7f);
                this.hPL.setText(this.hoL);
                this.hPL.setVisibility(0);
            } else if (this.gQS == 1) {
                SkinManager.setViewTextColor(this.hPL, a.c.sdk_hk_gradient_color_start);
                this.hPL.setAlpha(0.7f);
                String closeReason = this.mLiveInfo.getCloseReason();
                if (TextUtils.equals(closeReason, "0")) {
                    closeReason = "";
                }
                this.hPL.setText(closeReason);
                this.hPL.setVisibility(0);
                this.hPK.setText(this.mContext.getResources().getString(a.h.live_closed));
            } else if (this.gQS == 0) {
                this.hPL.setVisibility(8);
            }
            this.hPM.setText(StringUtils.translateSecondsToString2((int) this.mLiveInfo.getLiveDuration()));
            if (this.mLiveInfo.familyFansCount > 10000) {
                this.hPN.setText(j.numFormatOverWanNaForAudienceNum(this.mLiveInfo.familyFansCount));
            } else {
                this.hPN.setText(j.formatTosepara(this.mLiveInfo.familyFansCount));
            }
            this.hPO.setText(j.formatTosepara(this.mLiveInfo.newFansCount));
            this.hPP.setText(j.formatTosepara(this.mLiveInfo.rewardUserCount));
            this.hPQ.setText(j.formatTosepara(this.mLiveInfo.charm_count));
            this.hPG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.hPE != null) {
                        b.this.hPE.Pj();
                    }
                }
            });
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.hPS.setBackgroundResource(a.e.round_sharebtn_hk_bg_radius_12_n);
            } else {
                this.hPS.setBackgroundResource(a.e.sdk_round_btn_qm_bg_radius_40_n);
            }
            final String str4 = this.mLiveInfo.live_id + "";
            final String str5 = this.mLiveInfo.room_id + "";
            if (this.mLiveInfo.feed_id == null || TextUtils.equals(this.mLiveInfo.feed_id, "null")) {
                str2 = "";
            } else {
                str2 = this.mLiveInfo.feed_id;
            }
            this.hPS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.b.2
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
                    if (b.this.hPE != null) {
                        boolean z2 = !TextUtils.isEmpty(b.this.mLiveInfo.qrcodeDownloadUrl) && b.this.hQb;
                        try {
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(b.this.hQd) && (file = new File(b.this.hQd)) != null && file.exists()) {
                            if (file.isFile()) {
                                z = true;
                                if (z || b.this.hQc != z2) {
                                    b.this.hQd = b.this.oH(z2);
                                }
                                if (z2) {
                                    b.this.hQc = true;
                                }
                                if (TextUtils.isEmpty(b.this.hQd)) {
                                    b.this.hPE.hY(b.this.hQd);
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
                        b.this.hQd = b.this.oH(z2);
                        if (z2) {
                        }
                        if (TextUtils.isEmpty(b.this.hQd)) {
                        }
                    }
                }
            });
            this.hPU.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.ala.liveroom.views.b.3
                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onComplete(String str6, boolean z) {
                    if (TextUtils.equals(str6, b.this.mLiveInfo.qrcodeDownloadUrl)) {
                        b.this.hQb = z;
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
            this.hPV.setText(str6);
            String nameShow = this.mLiveInfo.getNameShow();
            if (nameShow == null) {
                nameShow = "";
            }
            this.hPW.setText("长按二维码认识 " + nameShow);
            if (cnR()) {
                this.hPY.setVisibility(0);
                this.hPZ.setText(this.mContext.getResources().getString(a.h.ala_live_end_official_qq_group) + " " + com.baidu.live.af.a.SE().bwi.aPc.aKE);
                this.hQa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.b.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        b.this.copyToClipboard(com.baidu.live.af.a.SE().bwi.aPc.aKE);
                        BdToast.makeText(b.this.mContext, b.this.mContext.getResources().getString(a.h.ala_live_end_copy_qq_to_clipboard)).setDuration(17).show();
                    }
                });
            } else {
                this.hPY.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.mLiveInfo.qrcodeDownloadUrl)) {
                this.hPU.startLoad(this.mLiveInfo.qrcodeDownloadUrl, 10, false);
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
    public void cA(boolean z) {
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    private boolean cnR() {
        return (com.baidu.live.af.a.SE().bwi == null || com.baidu.live.af.a.SE().bwi.aPc == null || TextUtils.isEmpty(com.baidu.live.af.a.SE().bwi.aPc.aKE)) ? false : true;
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
    public String oH(boolean z) {
        String str;
        String str2;
        RelativeLayout relativeLayout = this.hPF;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
        Calendar.getInstance().add(5, 0);
        String charSequence = TextUtils.concat("screenshot_", simpleDateFormat.format(new Date()), ".jpg").toString();
        Bitmap createBitmap = Bitmap.createBitmap(relativeLayout.getWidth(), relativeLayout.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        this.hPG.setVisibility(8);
        this.hPI.setVisibility(8);
        this.hPJ.setVisibility(0);
        this.hPR.setVisibility(8);
        this.hPY.setVisibility(8);
        if (z) {
            this.hPT.setAlpha(1.0f);
        }
        relativeLayout.draw(canvas);
        this.hPG.setVisibility(0);
        this.hPI.setVisibility(0);
        this.hPJ.setVisibility(4);
        this.hPR.setVisibility(0);
        if (cnR()) {
            this.hPY.setVisibility(0);
        }
        this.hPT.setAlpha(0.0f);
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
