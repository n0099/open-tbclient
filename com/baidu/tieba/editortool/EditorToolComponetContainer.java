package com.baidu.tieba.editortool;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.editortool.EmotionTabHost;
import com.baidu.tbadk.editortool.ToolMoreView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.img.view.DragContainer;
import com.baidu.tieba.img.view.DragHorizonScrollView;
import com.baidu.tieba.img.view.DragLayer;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class EditorToolComponetContainer extends RelativeLayout implements com.baidu.tieba.img.view.d {
    protected LinearLayout Hk;
    private com.baidu.tbadk.editortool.w RC;
    private boolean SU;
    protected View aqA;
    protected ImageView aqB;
    protected DragContainer aqC;
    protected DragLayer aqD;
    protected DragHorizonScrollView aqE;
    protected DragContainer aqF;
    protected DragLayer aqG;
    protected DragHorizonScrollView aqH;
    protected TextView aqI;
    protected TextView aqJ;
    protected ar aqK;
    protected boolean aqL;
    private AlertDialog.Builder aqM;
    private final boolean aqN;
    private boolean aqO;
    private int aqP;
    protected final ba aqQ;
    private WriteImagesInfo aqR;
    private WriteImagesInfo aqS;
    private com.baidu.tbadk.img.e aqT;
    protected ToolMoreView aqw;
    protected EmotionTabHost aqx;
    protected com.baidu.tieba.voice.a aqy;
    protected com.baidu.tieba.voice.f aqz;
    protected Context mContext;
    private int padding;

    public EditorToolComponetContainer(Context context) {
        super(context);
        this.aqL = false;
        this.aqM = null;
        this.aqN = true;
        this.SU = false;
        this.aqQ = new ba();
        this.mContext = context;
        ny();
    }

    public EditorToolComponetContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aqL = false;
        this.aqM = null;
        this.aqN = true;
        this.SU = false;
        this.aqQ = new ba();
        this.mContext = context;
        ny();
    }

    protected void ny() {
        com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.w.editor_tool_container, this, true);
        this.Hk = (LinearLayout) findViewById(com.baidu.tieba.v.tools_container);
        this.aqw = (ToolMoreView) findViewById(com.baidu.tieba.v.tool_view);
        this.aqM = new AlertDialog.Builder(this.mContext);
        this.aqM.setTitle(com.baidu.tieba.y.editor_dialog_title);
        this.aqM.setNegativeButton(com.baidu.tieba.y.editor_dialog_no, (DialogInterface.OnClickListener) null);
        this.aqB = (ImageView) findViewById(com.baidu.tieba.v.pb_foot_down_shadow);
        if (com.baidu.tieba.e.a.adG() && this.aqw.getBaobao() != null && this.aqw.getBaobao().isShown()) {
            this.aqw.dk("N");
        }
    }

    private void Bh() {
        if (this.aqy == null) {
            this.aqy = new com.baidu.tieba.voice.a(this.mContext);
            this.Hk.addView(this.aqy, new LinearLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.pb_editor_faceview_height)));
            this.aqy.setVisibility(8);
            com.baidu.tbadk.core.util.aw.h(this.aqy, com.baidu.tieba.s.record_voice_container_bg);
            if (this.aqz != null) {
                this.aqy.setCallback(this.aqz);
            }
            if (this.RC != null) {
                this.RC.handleAction(54, null);
            }
        }
    }

    private void Bi() {
        if (this.aqx == null) {
            this.aqx = new EmotionTabHost(this.mContext);
            this.Hk.addView(this.aqx, new LinearLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.pb_editor_faceview_height)));
            this.aqx.setVisibility(8);
            this.aqx.setShowBigEmotion(!this.aqO);
            this.aqx.onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
            this.aqx.setOnDataSelected(new m(this));
        }
    }

    private void Bj() {
        if (this.aqC == null) {
            com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.editor_tool_container_image, this.Hk);
            this.aqC = (DragContainer) findViewById(com.baidu.tieba.v.muti_image_upload);
            this.aqD = (DragLayer) findViewById(com.baidu.tieba.v.muti_image_upload_draglayer);
            this.aqE = (DragHorizonScrollView) findViewById(com.baidu.tieba.v.muti_image_upload_dragscrollview);
            com.baidu.tieba.img.view.a aVar = new com.baidu.tieba.img.view.a(getContext());
            aVar.a(this.aqD);
            aVar.a((com.baidu.tieba.img.view.g) this.aqE);
            aVar.a((com.baidu.tieba.img.view.f) this.aqE);
            this.aqJ = (TextView) findViewById(com.baidu.tieba.v.muti_image_tips);
            this.aqP = getResources().getDimensionPixelSize(com.baidu.tieba.t.editor_muti_image_upload_scrollview_paddingleft);
            this.padding = getResources().getDimensionPixelSize(com.baidu.tieba.t.default_gap_24);
            this.aqE.setAddView(ep(7));
            this.aqE.setOnSwapDataListener(this);
            this.aqE.setMaxItemNum(10);
            if (this.aqT == null) {
                this.aqT = new com.baidu.tbadk.img.e(this.mContext);
            }
        }
    }

    private void Bk() {
        if (this.aqF == null) {
            com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.editor_tool_container_baobao, this.Hk);
            this.aqF = (DragContainer) findViewById(com.baidu.tieba.v.baobao_image_upload);
            this.aqG = (DragLayer) findViewById(com.baidu.tieba.v.baobao_image_upload_draglayer);
            this.aqH = (DragHorizonScrollView) findViewById(com.baidu.tieba.v.baobao_image_upload_dragscrollview);
            this.aqI = (TextView) findViewById(com.baidu.tieba.v.baobao_image_tips);
            com.baidu.tieba.img.view.a aVar = new com.baidu.tieba.img.view.a(getContext());
            aVar.a(this.aqG);
            aVar.a((com.baidu.tieba.img.view.g) this.aqH);
            aVar.a((com.baidu.tieba.img.view.f) this.aqH);
            this.aqH.setAddView(ep(48));
            this.aqH.setOnSwapDataListener(this);
            this.aqH.setMaxItemNum(1);
            this.aqH.setCenterStart(true);
            if (this.aqT == null) {
                this.aqT = new com.baidu.tbadk.img.e(this.mContext);
            }
        }
    }

    private void Bl() {
        if (this.aqK == null) {
            this.aqK = new ar(this.mContext);
            this.Hk.addView(this.aqK, new LinearLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.pb_editor_faceview_height)));
            this.aqK.setVisibility(8);
            this.aqK.onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
            this.aqK.setOnDataSelected(new n(this));
        }
    }

    protected void Bm() {
        if (this.mContext instanceof BaseActivity) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2010041, this.aqQ);
            customResponsedMessage.setOrginalMessage(new CustomMessage(2010041, ((BaseActivity) this.mContext).getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessageToUI(customResponsedMessage);
        } else if (this.mContext instanceof BaseFragmentActivity) {
            CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(2010041, this.aqQ);
            customResponsedMessage2.setOrginalMessage(new CustomMessage(2010041, ((BaseFragmentActivity) this.mContext).getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessageToUI(customResponsedMessage2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Bn() {
        if (BN()) {
            this.aqQ.asb = 1;
        } else {
            this.aqQ.asb = 0;
        }
        if (this.aqR != null && this.aqR.getChosedFiles() != null && this.aqR.getChosedFiles().size() > 0) {
            this.aqQ.asa = this.aqR.getChosedFiles().size();
        } else {
            this.aqQ.asa = 0;
        }
        if (this.aqS != null && this.aqS.getChosedFiles() != null && this.aqS.getChosedFiles().size() > 0) {
            this.aqQ.asc = this.aqS.getChosedFiles().size();
        } else {
            this.aqQ.asc = 0;
        }
        Bm();
    }

    public void setHideBaobao(boolean z) {
        this.SU = z;
        if (this.aqw != null) {
            this.aqw.setHideBaobao(z);
            if (z && com.baidu.tieba.e.a.adG()) {
                this.aqw.rK();
            }
        }
    }

    public void setFrom(int i) {
        if (this.aqx != null) {
            this.aqx.setFrom(i);
        }
    }

    protected void Bo() {
        Bi();
        this.aqB.setVisibility(0);
        if (TbadkApplication.m251getInst().getKeyboardHeight() > 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aqx.getLayoutParams();
            layoutParams.height = TbadkApplication.m251getInst().getKeyboardHeight();
            this.aqx.setLayoutParams(layoutParams);
        }
        this.aqx.setVisibility(0);
    }

    protected void Bp() {
        if (this.aqx != null) {
            this.aqx.setVisibility(8);
        }
    }

    public void Bq() {
        View recordButton;
        if (this.aqw != null && (recordButton = this.aqw.getRecordButton()) != null) {
            recordButton.setVisibility(4);
        }
    }

    public void Br() {
        View recordButton;
        if (this.aqw != null && (recordButton = this.aqw.getRecordButton()) != null) {
            recordButton.setVisibility(0);
        }
    }

    protected void Bs() {
        Bh();
        this.aqB.setVisibility(0);
        if (TbadkApplication.m251getInst().isKeyboardHeightCanUsed()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aqy.getLayoutParams();
            layoutParams.height = TbadkApplication.m251getInst().getKeyboardHeight();
            this.aqy.setLayoutParams(layoutParams);
        }
        this.aqy.setVisibility(0);
    }

    protected void Bt() {
        if (this.aqy != null) {
            this.aqy.setVisibility(8);
        }
    }

    protected void Bu() {
        this.aqB.setVisibility(0);
        if (TbadkApplication.m251getInst().isKeyboardHeightCanUsed()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aqw.getLayoutParams();
            layoutParams.height = TbadkApplication.m251getInst().getKeyboardHeight();
            this.aqw.setLayoutParams(layoutParams);
        }
        this.aqw.setVisibility(0);
    }

    public void Bv() {
        if (this.aqC != null) {
            this.aqC.setVisibility(8);
        }
    }

    public void Bw() {
        Bj();
        this.aqB.setVisibility(0);
        if (TbadkApplication.m251getInst().isKeyboardHeightCanUsed()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aqC.getLayoutParams();
            layoutParams.height = TbadkApplication.m251getInst().getKeyboardHeight();
            this.aqC.setLayoutParams(layoutParams);
        }
        this.aqC.setVisibility(0);
    }

    public void Bx() {
        if (this.aqF != null) {
            this.aqF.setVisibility(8);
        }
    }

    public void rK() {
        this.aqw.rK();
    }

    public void di(String str) {
        if (this.aqw != null) {
            this.aqw.di(str);
        }
    }

    public void rD() {
        if (this.aqw != null) {
            this.aqw.rD();
        }
    }

    public void rL() {
        if (this.aqw != null) {
            this.aqw.rL();
        }
    }

    public void rM() {
        if (this.aqw != null) {
            this.aqw.rM();
        }
    }

    public boolean rH() {
        if (this.aqw == null) {
            return false;
        }
        return this.aqw.rH();
    }

    public void rI() {
        if (this.aqw != null) {
            this.aqw.rI();
        }
    }

    public void rJ() {
        if (this.aqw != null) {
            this.aqw.rJ();
        }
    }

    public void By() {
        Bk();
        this.aqB.setVisibility(0);
        if (TbadkApplication.m251getInst().isKeyboardHeightCanUsed()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aqF.getLayoutParams();
            layoutParams.height = TbadkApplication.m251getInst().getKeyboardHeight();
            this.aqF.setLayoutParams(layoutParams);
        }
        this.aqF.setVisibility(0);
        if (TextUtils.isEmpty(this.aqI.getText())) {
            this.aqI.setText(com.baidu.tieba.y.baobao_remind);
        }
    }

    protected void hideMore() {
        this.aqw.setVisibility(8);
    }

    protected void Bz() {
        Bl();
        this.aqB.setVisibility(0);
        if (TbadkApplication.m251getInst().isKeyboardHeightCanUsed()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aqK.getLayoutParams();
            layoutParams.height = TbadkApplication.m251getInst().getKeyboardHeight();
            this.aqK.setLayoutParams(layoutParams);
        }
        this.aqK.setVisibility(0);
    }

    protected void BA() {
        if (this.aqK != null) {
            this.aqK.setVisibility(8);
        }
    }

    public void v(View view) {
        if (view != null) {
            com.baidu.adp.lib.util.m.c(this.mContext, view);
            this.aqL = true;
        }
    }

    public void w(View view) {
        if (view != null) {
            com.baidu.adp.lib.util.m.b(this.mContext, view);
            this.aqL = false;
        }
    }

    public boolean BB() {
        return this.aqw.getVisibility() == 0 || (this.aqy != null && this.aqy.getVisibility() == 0) || ((this.aqx != null && this.aqx.getVisibility() == 0) || ((this.aqC != null && this.aqC.getVisibility() == 0) || ((this.aqK != null && this.aqK.getVisibility() == 0) || (this.aqF != null && this.aqF.getVisibility() == 0))));
    }

    public void BC() {
        BD();
        w(this.aqA);
    }

    public void BD() {
        this.aqB.setVisibility(8);
        hideMore();
        Bt();
        Bp();
        Bv();
        BA();
        Bx();
    }

    public void BE() {
        if (TbadkApplication.m251getInst().isKeyboardHeightCanUsed()) {
            if (this.aqw != null && this.aqw.getVisibility() == 0) {
                Bu();
            } else if (this.aqx != null && this.aqx.getVisibility() == 0) {
                Bo();
            } else if (this.aqy != null && this.aqy.getVisibility() == 0) {
                Bs();
            } else if (this.aqC != null && this.aqC.getVisibility() == 0) {
                Bw();
            } else if (this.aqK != null && this.aqK.getVisibility() == 0) {
                Bz();
            } else if (this.aqF != null && this.aqF.getVisibility() == 0) {
                By();
            }
        }
    }

    public void BF() {
        BC();
        Bu();
    }

    public void BG() {
        BC();
        Bo();
    }

    public void BH() {
        BC();
        Bs();
    }

    public void BI() {
        BC();
        Bw();
    }

    public void BJ() {
        BC();
        Bz();
    }

    public void BK() {
        BC();
        By();
    }

    public void x(View view) {
        if (!this.aqL) {
            BC();
            this.aqA = view;
            v(view);
        }
    }

    public boolean BL() {
        BaseAdapter adapter;
        return (this.aqE == null || (adapter = this.aqE.getAdapter()) == null || adapter.getCount() <= 0) ? false : true;
    }

    public boolean BM() {
        BaseAdapter adapter;
        return (this.aqH == null || (adapter = this.aqH.getAdapter()) == null || adapter.getCount() <= 0) ? false : true;
    }

    public boolean BN() {
        VoiceData.VoiceModel voiceModel;
        return (this.aqy == null || (voiceModel = this.aqy.getVoiceModel()) == null || voiceModel.getId() == null || voiceModel.getId().length() <= 0) ? false : true;
    }

    public VoiceData.VoiceModel getAudioData() {
        if (this.aqy == null) {
            return null;
        }
        return this.aqy.getVoiceModel();
    }

    public void BO() {
        if (this.aqz != null) {
            this.aqz.BU();
        }
    }

    public void setAudioData(VoiceData.VoiceModel voiceModel) {
        if (this.aqy != null && voiceModel != null) {
            this.aqy.d(voiceModel);
        }
    }

    public void BP() {
        if (this.aqy != null) {
            this.aqy.afa();
        }
    }

    public void clearData() {
        if (this.aqy != null) {
            this.aqy.reset();
            setImage(null);
            this.aqw.rK();
        }
    }

    public void BQ() {
        if (this.aqy != null) {
            this.aqy.onStopingRecorder();
        }
    }

    public void BR() {
        BQ();
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        this.RC = new o(this, wVar);
        this.aqM.setPositiveButton(com.baidu.tieba.y.editor_dialog_yes, new p(this));
        this.aqw.setOnClickListener(new q(this));
        this.aqz = new r(this);
        if (this.aqy != null) {
            this.aqy.setCallback(this.aqz);
        }
    }

    public boolean BS() {
        return this.aqL;
    }

    public void setImage(Bitmap bitmap) {
        if (bitmap == null) {
            this.aqw.setmImagetype(0);
        }
        this.aqw.setImage(bitmap);
    }

    public void au(boolean z) {
        this.aqO = z;
        this.aqw.au(z);
        if (this.aqx != null) {
            this.aqx.setShowBigEmotion(!z);
        }
    }

    public void rO() {
        this.aqw.rO();
    }

    public void onChangeSkinType(int i) {
        if (this.aqx != null) {
            this.aqx.onChangeSkinType(i);
        }
        this.aqw.onChangeSkinType(i);
        if (this.aqK != null) {
            this.aqK.onChangeSkinType(i);
        }
        if (this.aqy != null) {
            com.baidu.tbadk.core.util.aw.h(this.aqy, com.baidu.tieba.s.record_voice_container_bg);
        }
    }

    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        Bj();
        this.aqR = writeImagesInfo;
        this.aqE.a(new t(this, writeImagesInfo), z);
        int maxItemNum = this.aqE.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (!com.baidu.tieba.aj.wk().wV() && size > 1) {
            this.aqJ.setText(com.baidu.tieba.y.editor_mutiiamge_drag_tip);
            com.baidu.tieba.aj.wk().be(true);
        } else {
            this.aqJ.setText(getResources().getString(com.baidu.tieba.y.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
        }
        if (size > 0) {
            this.aqw.di(new StringBuilder(String.valueOf(size)).toString());
        } else {
            this.aqw.rD();
        }
        this.RC.handleAction(13, null);
        Bn();
    }

    public void setBaobaoUris(WriteImagesInfo writeImagesInfo) {
        Bk();
        this.aqS = writeImagesInfo;
        this.aqH.a((BaseAdapter) new t(this, this.aqS), false);
        this.RC.handleAction(51, null);
        if (this.aqS.size() > 0) {
            this.aqw.dk("1");
        } else {
            this.aqw.rK();
        }
        this.RC.handleAction(51, null);
        Bn();
    }

    private View ep(int i) {
        TbadkApplication.m251getInst().getSkinType();
        ImageView imageView = new ImageView(getContext());
        com.baidu.tbadk.core.util.aw.c(imageView, com.baidu.tieba.u.btn_add_photo_selector);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setClickable(true);
        int dip2px = com.baidu.adp.lib.util.m.dip2px(this.mContext, 3.0f);
        imageView.setPadding(dip2px, com.baidu.adp.lib.util.m.dip2px(this.mContext, 1.0f) + getResources().getDimensionPixelSize(com.baidu.tieba.t.default_gap_20) + dip2px, this.padding + dip2px, dip2px);
        imageView.setOnClickListener(new s(this, i));
        return imageView;
    }

    public void BT() {
        if (this.aqE != null) {
            this.aqE.notifyDataSetChanged();
        }
        if (this.aqH != null) {
            this.aqH.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.img.view.d
    public void G(int i, int i2) {
        if (i != i2 && this.aqR != null && this.aqR.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.aqR.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void refresh() {
        if (this.aqO) {
            this.aqw.rG();
        } else if (TextUtils.isEmpty(TbadkApplication.m251getInst().getDefaultBubble()) && !this.aqO) {
            this.aqw.rG();
        } else {
            this.aqw.rF();
        }
    }
}
