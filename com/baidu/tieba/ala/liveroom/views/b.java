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
import com.baidu.live.data.u;
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
    private TextView aZl;
    private int fUD;
    private HeadImageView fVe;
    private com.baidu.live.liveroom.middleware.a.e gNH;
    private RelativeLayout gNI;
    private ImageView gNJ;
    private TextView gNK;
    private LinearLayout gNL;
    private LinearLayout gNM;
    private TextView gNN;
    private TextView gNO;
    private TextView gNP;
    private TextView gNQ;
    private TextView gNR;
    private TextView gNS;
    private TextView gNT;
    private FrameLayout gNU;
    private TextView gNV;
    private FrameLayout gNW;
    private TbImageView gNX;
    private TextView gNY;
    private TextView gNZ;
    private RelativeLayout gOa;
    private LinearLayout gOb;
    private TextView gOc;
    private TextView gOd;
    private String gOg;
    private Context mContext;
    private AlaLiveInfoData mLiveInfo;
    private String mPortrait;
    private View rootView;
    private boolean gOe = false;
    private boolean gOf = false;
    private String gnw = null;
    private String otherParams = "";

    @Override // com.baidu.live.liveroom.middleware.i
    public void r(Activity activity) {
        this.mContext = activity;
        initUI();
    }

    @Override // com.baidu.live.liveroom.middleware.a.b
    public View a(u uVar, com.baidu.live.liveroom.middleware.a.e eVar, int i, String str, String str2, String str3) {
        this.mPortrait = str2;
        this.fUD = i;
        this.gnw = str;
        this.gNH = eVar;
        d(uVar, str3);
        return this.rootView;
    }

    @Override // com.baidu.live.liveroom.middleware.a.b
    public View a(u uVar, String str) {
        d(uVar, str);
        return this.rootView;
    }

    private void initUI() {
        this.rootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_live_end_view_layout, (ViewGroup) null);
        this.gNI = (RelativeLayout) this.rootView.findViewById(a.g.inner_layout);
        this.gNJ = (ImageView) this.rootView.findViewById(a.g.imgClose);
        this.fVe = (HeadImageView) this.rootView.findViewById(a.g.avatar_imageView);
        this.gNK = (TextView) this.rootView.findViewById(a.g.username_textView);
        this.gNL = (LinearLayout) this.rootView.findViewById(a.g.endTitle_layout);
        this.gNM = (LinearLayout) this.rootView.findViewById(a.g.achievement_layout);
        this.aZl = (TextView) this.rootView.findViewById(a.g.title_textView);
        this.gNN = (TextView) this.rootView.findViewById(a.g.tvLiveEndTitle);
        this.gNO = (TextView) this.rootView.findViewById(a.g.tvLiveEndSubTitle);
        this.gNP = (TextView) this.rootView.findViewById(a.g.tvLiveEndUseTime);
        this.gNQ = (TextView) this.rootView.findViewById(a.g.tvLiveEndWatchNum);
        this.gNR = (TextView) this.rootView.findViewById(a.g.tvLiveEndNewFansNum);
        this.gNS = (TextView) this.rootView.findViewById(a.g.tvLiveEndGiverNum);
        this.gNT = (TextView) this.rootView.findViewById(a.g.tvLiveEndNewCharmNum);
        this.gNU = (FrameLayout) this.rootView.findViewById(a.g.share_layout);
        this.gNV = (TextView) this.rootView.findViewById(a.g.share_textView);
        this.gNW = (FrameLayout) this.rootView.findViewById(a.g.qr_layout);
        this.gNX = (TbImageView) this.rootView.findViewById(a.g.qr_imageView);
        this.gNY = (TextView) this.rootView.findViewById(a.g.appName_textView);
        this.gNZ = (TextView) this.rootView.findViewById(a.g.qrIntroduce_textView);
        this.gOa = (RelativeLayout) this.rootView.findViewById(a.g.userHead_layout);
        this.gOb = (LinearLayout) this.rootView.findViewById(a.g.official_qq_group_ll);
        this.gOc = (TextView) this.rootView.findViewById(a.g.official_qq_group);
        this.gOd = (TextView) this.rootView.findViewById(a.g.copy_official_qq_group);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.gNL.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gNJ.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.topMargin += UtilHelper.getStatusBarHeight();
                this.gNJ.setLayoutParams(layoutParams);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gOa.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.topMargin += UtilHelper.getStatusBarHeight();
                this.gOa.setLayoutParams(layoutParams2);
            }
        }
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTER_CLOSE_LIVE_BEGIN);
            alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CLOSE_LIVE));
        }
    }

    private void d(u uVar, String str) {
        final String str2;
        if (uVar != null && uVar.mLiveInfo != null) {
            this.mLiveInfo = uVar.mLiveInfo;
            this.fVe.setIsRound(true);
            this.fVe.setDrawBorder(true);
            this.fVe.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.fVe.setAutoChangeStyle(false);
            if (TextUtils.isEmpty(this.mPortrait)) {
                this.fVe.setDefaultResource(a.f.pic_avatar_moren);
            } else if (!TextUtils.equals(this.fVe.getUrl(), this.mPortrait)) {
                this.fVe.startLoad(this.mPortrait, 12, false, false);
            }
            if (TextUtils.isEmpty(str) || "null".equals(str)) {
                str = this.mLiveInfo.getNameShow();
            }
            if (!TextUtils.isEmpty(str) && str.length() > 10) {
                str = str.substring(0, 8) + StringHelper.STRING_MORE;
            }
            this.gNK.setText(Html.fromHtml(String.format("亲爱的<font color='#fed500'>%s</font>，本次直播荣获称号", str)));
            String str3 = uVar.mLiveInfo.anchorTitle;
            this.aZl.setText((TextUtils.isEmpty(str3) || TextUtils.equals(str3, "null")) ? "" : "");
            this.gNN.setText(this.mContext.getResources().getString(a.i.live_over_name));
            if (!TextUtils.isEmpty(this.gnw)) {
                SkinManager.setViewTextColor(this.gNO, a.d.sdk_hk_gradient_color_start);
                this.gNO.setAlpha(0.7f);
                this.gNO.setText(this.gnw);
                this.gNO.setVisibility(0);
            } else if (this.fUD == 1) {
                SkinManager.setViewTextColor(this.gNO, a.d.sdk_hk_gradient_color_start);
                this.gNO.setAlpha(0.7f);
                String closeReason = this.mLiveInfo.getCloseReason();
                if (TextUtils.equals(closeReason, "0")) {
                    closeReason = "";
                }
                this.gNO.setText(closeReason);
                this.gNO.setVisibility(0);
                this.gNN.setText(this.mContext.getResources().getString(a.i.live_closed));
            } else if (this.fUD == 0) {
                this.gNO.setVisibility(8);
            }
            this.gNP.setText(StringUtils.translateSecondsToString2((int) this.mLiveInfo.getLiveDuration()));
            if (this.mLiveInfo.familyFansCount > 10000) {
                this.gNQ.setText(j.numFormatOverWanNaForAudienceNum(this.mLiveInfo.familyFansCount));
            } else {
                this.gNQ.setText(j.formatTosepara(this.mLiveInfo.familyFansCount));
            }
            this.gNR.setText(j.formatTosepara(this.mLiveInfo.newFansCount));
            this.gNS.setText(j.formatTosepara(this.mLiveInfo.rewardUserCount));
            this.gNT.setText(j.formatTosepara(this.mLiveInfo.charm_count));
            this.gNJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.gNH != null) {
                        b.this.gNH.LO();
                    }
                }
            });
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gNV.setBackgroundResource(a.f.round_sharebtn_hk_bg_radius_12_n);
            } else {
                this.gNV.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_40_n);
            }
            final String str4 = this.mLiveInfo.live_id + "";
            final String str5 = this.mLiveInfo.room_id + "";
            if (this.mLiveInfo.feed_id == null || TextUtils.equals(this.mLiveInfo.feed_id, "null")) {
                str2 = "";
            } else {
                str2 = this.mLiveInfo.feed_id;
            }
            this.gNV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.b.2
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
                    if (b.this.gNH != null) {
                        boolean z2 = !TextUtils.isEmpty(b.this.mLiveInfo.qrcodeDownloadUrl) && b.this.gOe;
                        try {
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(b.this.gOg) && (file = new File(b.this.gOg)) != null && file.exists()) {
                            if (file.isFile()) {
                                z = true;
                                if (z || b.this.gOf != z2) {
                                    b.this.gOg = b.this.mK(z2);
                                }
                                if (z2) {
                                    b.this.gOf = true;
                                }
                                if (TextUtils.isEmpty(b.this.gOg)) {
                                    b.this.gNH.hk(b.this.gOg);
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
                        b.this.gOg = b.this.mK(z2);
                        if (z2) {
                        }
                        if (TextUtils.isEmpty(b.this.gOg)) {
                        }
                    }
                }
            });
            this.gNX.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.ala.liveroom.views.b.3
                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onComplete(String str6, boolean z) {
                    if (TextUtils.equals(str6, b.this.mLiveInfo.qrcodeDownloadUrl)) {
                        b.this.gOe = z;
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
            this.gNY.setText(str6);
            String nameShow = this.mLiveInfo.getNameShow();
            if (nameShow == null) {
                nameShow = "";
            }
            this.gNZ.setText("长按二维码认识 " + nameShow);
            if (bYE()) {
                this.gOb.setVisibility(0);
                this.gOc.setText(this.mContext.getResources().getString(a.i.ala_live_end_official_qq_group) + " " + com.baidu.live.x.a.NN().bhy.aID.aEJ);
                this.gOd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.b.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        b.this.copyToClipboard(com.baidu.live.x.a.NN().bhy.aID.aEJ);
                        BdToast.makeText(b.this.mContext, b.this.mContext.getResources().getString(a.i.ala_live_end_copy_qq_to_clipboard)).setDuration(17).show();
                    }
                });
            } else {
                this.gOb.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.mLiveInfo.qrcodeDownloadUrl)) {
                this.gNX.startLoad(this.mLiveInfo.qrcodeDownloadUrl, 10, false);
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

    private boolean bYE() {
        return (com.baidu.live.x.a.NN().bhy == null || com.baidu.live.x.a.NN().bhy.aID == null || TextUtils.isEmpty(com.baidu.live.x.a.NN().bhy.aID.aEJ)) ? false : true;
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
    public String mK(boolean z) {
        String str;
        String str2;
        RelativeLayout relativeLayout = this.gNI;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
        Calendar.getInstance().add(5, 0);
        String charSequence = TextUtils.concat("screenshot_", simpleDateFormat.format(new Date()), ".jpg").toString();
        Bitmap createBitmap = Bitmap.createBitmap(relativeLayout.getWidth(), relativeLayout.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        this.gNJ.setVisibility(8);
        this.gNL.setVisibility(8);
        this.gNM.setVisibility(0);
        this.gNU.setVisibility(8);
        this.gOb.setVisibility(8);
        if (z) {
            this.gNW.setAlpha(1.0f);
        }
        relativeLayout.draw(canvas);
        this.gNJ.setVisibility(0);
        this.gNL.setVisibility(0);
        this.gNM.setVisibility(4);
        this.gNU.setVisibility(0);
        if (bYE()) {
            this.gOb.setVisibility(0);
        }
        this.gNW.setAlpha(0.0f);
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
