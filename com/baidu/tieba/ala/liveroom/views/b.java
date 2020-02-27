package com.baidu.tieba.ala.liveroom.views;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Environment;
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
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.m;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
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
    private TextView dAX;
    private HeadImageView eGz;
    private com.baidu.live.liveroom.middleware.a.e flK;
    private RelativeLayout flL;
    private ImageView flM;
    private TextView flN;
    private LinearLayout flO;
    private LinearLayout flP;
    private TextView flQ;
    private TextView flR;
    private TextView flS;
    private TextView flT;
    private TextView flU;
    private TextView flV;
    private TextView flW;
    private FrameLayout flX;
    private TextView flY;
    private FrameLayout flZ;
    private TbImageView fma;
    private TextView fmb;
    private TextView fmc;
    private RelativeLayout fmd;
    private String fmg;
    private Context mContext;
    private int mFromType;
    private AlaLiveInfoData mLiveInfo;
    private String mPortrait;
    private View rootView;
    private boolean fme = false;
    private boolean fmf = false;
    private String eOs = null;
    private String otherParams = "";

    @Override // com.baidu.live.liveroom.middleware.i
    public void u(Activity activity) {
        this.mContext = activity;
        initUI();
    }

    @Override // com.baidu.live.liveroom.middleware.a.b
    public View a(m mVar, com.baidu.live.liveroom.middleware.a.e eVar, int i, String str, String str2, String str3) {
        this.mPortrait = str2;
        this.mFromType = i;
        this.eOs = str;
        this.flK = eVar;
        d(mVar, str3);
        return this.rootView;
    }

    @Override // com.baidu.live.liveroom.middleware.a.b
    public View b(m mVar, String str) {
        d(mVar, str);
        return this.rootView;
    }

    private void initUI() {
        this.rootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_live_end_view_layout, (ViewGroup) null);
        this.flL = (RelativeLayout) this.rootView.findViewById(a.g.inner_layout);
        this.flM = (ImageView) this.rootView.findViewById(a.g.imgClose);
        this.eGz = (HeadImageView) this.rootView.findViewById(a.g.avatar_imageView);
        this.flN = (TextView) this.rootView.findViewById(a.g.username_textView);
        this.flO = (LinearLayout) this.rootView.findViewById(a.g.endTitle_layout);
        this.flP = (LinearLayout) this.rootView.findViewById(a.g.achievement_layout);
        this.dAX = (TextView) this.rootView.findViewById(a.g.title_textView);
        this.flQ = (TextView) this.rootView.findViewById(a.g.tvLiveEndTitle);
        this.flR = (TextView) this.rootView.findViewById(a.g.tvLiveEndSubTitle);
        this.flS = (TextView) this.rootView.findViewById(a.g.tvLiveEndUseTime);
        this.flT = (TextView) this.rootView.findViewById(a.g.tvLiveEndWatchNum);
        this.flU = (TextView) this.rootView.findViewById(a.g.tvLiveEndNewFansNum);
        this.flV = (TextView) this.rootView.findViewById(a.g.tvLiveEndGiverNum);
        this.flW = (TextView) this.rootView.findViewById(a.g.tvLiveEndNewCharmNum);
        this.flX = (FrameLayout) this.rootView.findViewById(a.g.share_layout);
        this.flY = (TextView) this.rootView.findViewById(a.g.share_textView);
        this.flZ = (FrameLayout) this.rootView.findViewById(a.g.qr_layout);
        this.fma = (TbImageView) this.rootView.findViewById(a.g.qr_imageView);
        this.fmb = (TextView) this.rootView.findViewById(a.g.appName_textView);
        this.fmc = (TextView) this.rootView.findViewById(a.g.qrIntroduce_textView);
        this.fmd = (RelativeLayout) this.rootView.findViewById(a.g.userHead_layout);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.flO.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.flM.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.topMargin += UtilHelper.getStatusBarHeight();
                this.flM.setLayoutParams(layoutParams);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fmd.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.topMargin += UtilHelper.getStatusBarHeight();
                this.fmd.setLayoutParams(layoutParams2);
            }
        }
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTER_CLOSE_LIVE_BEGIN);
            alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CLOSE_LIVE));
        }
    }

    private void d(m mVar, String str) {
        final String str2;
        if (mVar != null && mVar.mLiveInfo != null) {
            this.mLiveInfo = mVar.mLiveInfo;
            this.eGz.setIsRound(true);
            this.eGz.setDrawBorder(true);
            this.eGz.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.eGz.setAutoChangeStyle(false);
            if (TextUtils.isEmpty(this.mPortrait)) {
                this.eGz.setDefaultResource(a.f.pic_avatar_moren);
            } else {
                this.eGz.startLoad(this.mPortrait, 12, false, false);
            }
            if (TextUtils.isEmpty(str) || "null".equals(str)) {
                str = this.mLiveInfo.getNameShow();
            }
            if (!TextUtils.isEmpty(str) && str.length() > 10) {
                str = str.substring(0, 8) + StringHelper.STRING_MORE;
            }
            this.flN.setText(Html.fromHtml(String.format("亲爱的<font color='#fed500'>%s</font>，本次直播荣获称号", str)));
            String str3 = mVar.mLiveInfo.anchorTitle;
            this.dAX.setText((TextUtils.isEmpty(str3) || TextUtils.equals(str3, "null")) ? "" : "");
            this.flQ.setText(this.mContext.getResources().getString(a.i.live_over_name));
            if (!TextUtils.isEmpty(this.eOs)) {
                SkinManager.setViewTextColor(this.flR, a.d.sdk_hk_gradient_color_start);
                this.flR.setAlpha(0.7f);
                this.flR.setText(this.eOs);
                this.flR.setVisibility(0);
            } else if (this.mFromType == 1) {
                SkinManager.setViewTextColor(this.flR, a.d.sdk_hk_gradient_color_start);
                this.flR.setAlpha(0.7f);
                String closeReason = this.mLiveInfo.getCloseReason();
                if (TextUtils.equals(closeReason, "0")) {
                    closeReason = "";
                }
                this.flR.setText(closeReason);
                this.flR.setVisibility(0);
                this.flQ.setText(this.mContext.getResources().getString(a.i.live_closed));
            } else if (this.mFromType == 0) {
                this.flR.setVisibility(8);
            }
            this.flS.setText(StringUtils.translateSecondsToString2((int) this.mLiveInfo.getLiveDuration()));
            if (this.mLiveInfo.familyFansCount > 10000) {
                this.flT.setText(i.numFormatOverWanNaForAudienceNum(this.mLiveInfo.familyFansCount));
            } else {
                this.flT.setText(i.formatTosepara(this.mLiveInfo.familyFansCount));
            }
            this.flU.setText(i.formatTosepara(this.mLiveInfo.newFansCount));
            this.flV.setText(i.formatTosepara(this.mLiveInfo.rewardUserCount));
            this.flW.setText(i.formatTosepara(this.mLiveInfo.charm_count));
            this.flM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.flK != null) {
                        b.this.flK.yF();
                    }
                }
            });
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.flY.setBackgroundResource(a.f.round_sharebtn_hk_bg_radius_12_n);
            } else {
                this.flY.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_40_n);
            }
            final String str4 = this.mLiveInfo.live_id + "";
            final String str5 = this.mLiveInfo.room_id + "";
            if (this.mLiveInfo.feed_id == null || TextUtils.equals(this.mLiveInfo.feed_id, "null")) {
                str2 = "";
            } else {
                str2 = this.mLiveInfo.feed_id;
            }
            this.flY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.b.2
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
                    if (b.this.flK != null) {
                        boolean z2 = !TextUtils.isEmpty(b.this.mLiveInfo.qrcodeDownloadUrl) && b.this.fme;
                        try {
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(b.this.fmg) && (file = new File(b.this.fmg)) != null && file.exists()) {
                            if (file.isFile()) {
                                z = true;
                                if (z || b.this.fmf != z2) {
                                    b.this.fmg = b.this.jN(z2);
                                }
                                if (z2) {
                                    b.this.fmf = true;
                                }
                                if (TextUtils.isEmpty(b.this.fmg)) {
                                    b.this.flK.dT(b.this.fmg);
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
                        b.this.fmg = b.this.jN(z2);
                        if (z2) {
                        }
                        if (TextUtils.isEmpty(b.this.fmg)) {
                        }
                    }
                }
            });
            this.fma.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.ala.liveroom.views.b.3
                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onComplete(String str6, boolean z) {
                    if (TextUtils.equals(str6, b.this.mLiveInfo.qrcodeDownloadUrl)) {
                        b.this.fme = z;
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
            this.fmb.setText(str6);
            String nameShow = this.mLiveInfo.getNameShow();
            if (nameShow == null) {
                nameShow = "";
            }
            this.fmc.setText("长按二维码认识 " + nameShow);
            if (!TextUtils.isEmpty(this.mLiveInfo.qrcodeDownloadUrl)) {
                this.fma.startLoad(this.mLiveInfo.qrcodeDownloadUrl, 10, false);
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
    public void be(boolean z) {
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX INFO: Access modifiers changed from: private */
    public String jN(boolean z) {
        String str;
        String str2;
        RelativeLayout relativeLayout = this.flL;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
        Calendar.getInstance().add(5, 0);
        String charSequence = TextUtils.concat("screenshot_", simpleDateFormat.format(new Date()), ".jpg").toString();
        Bitmap createBitmap = Bitmap.createBitmap(relativeLayout.getWidth(), relativeLayout.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        this.flM.setVisibility(8);
        this.flO.setVisibility(8);
        this.flP.setVisibility(0);
        this.flX.setVisibility(8);
        if (z) {
            this.flZ.setVisibility(0);
        }
        relativeLayout.draw(canvas);
        this.flM.setVisibility(0);
        this.flO.setVisibility(0);
        this.flP.setVisibility(4);
        this.flX.setVisibility(0);
        this.flZ.setVisibility(4);
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            str = TbadkCoreApplication.APP_ID_HAOKAN;
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
