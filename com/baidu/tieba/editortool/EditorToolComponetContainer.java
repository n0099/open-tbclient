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
    protected LinearLayout Hl;
    private com.baidu.tbadk.editortool.w RG;
    private boolean SY;
    protected ToolMoreView aqF;
    protected EmotionTabHost aqG;
    protected com.baidu.tieba.voice.a aqH;
    protected com.baidu.tieba.voice.f aqI;
    protected View aqJ;
    protected ImageView aqK;
    protected DragContainer aqL;
    protected DragLayer aqM;
    protected DragHorizonScrollView aqN;
    protected DragContainer aqO;
    protected DragLayer aqP;
    protected DragHorizonScrollView aqQ;
    protected TextView aqR;
    protected TextView aqS;
    protected ar aqT;
    protected boolean aqU;
    private AlertDialog.Builder aqV;
    private final boolean aqW;
    private boolean aqX;
    private int aqY;
    protected final ba aqZ;
    private WriteImagesInfo ara;
    private WriteImagesInfo arb;
    private com.baidu.tbadk.img.e arc;
    protected Context mContext;
    private int padding;

    public EditorToolComponetContainer(Context context) {
        super(context);
        this.aqU = false;
        this.aqV = null;
        this.aqW = true;
        this.SY = false;
        this.aqZ = new ba();
        this.mContext = context;
        ny();
    }

    public EditorToolComponetContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aqU = false;
        this.aqV = null;
        this.aqW = true;
        this.SY = false;
        this.aqZ = new ba();
        this.mContext = context;
        ny();
    }

    protected void ny() {
        com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.w.editor_tool_container, this, true);
        this.Hl = (LinearLayout) findViewById(com.baidu.tieba.v.tools_container);
        this.aqF = (ToolMoreView) findViewById(com.baidu.tieba.v.tool_view);
        this.aqV = new AlertDialog.Builder(this.mContext);
        this.aqV.setTitle(com.baidu.tieba.y.editor_dialog_title);
        this.aqV.setNegativeButton(com.baidu.tieba.y.editor_dialog_no, (DialogInterface.OnClickListener) null);
        this.aqK = (ImageView) findViewById(com.baidu.tieba.v.pb_foot_down_shadow);
        if (com.baidu.tieba.e.a.adJ() && this.aqF.getBaobao() != null && this.aqF.getBaobao().isShown()) {
            this.aqF.dk("N");
        }
    }

    private void Bj() {
        if (this.aqH == null) {
            this.aqH = new com.baidu.tieba.voice.a(this.mContext);
            this.Hl.addView(this.aqH, new LinearLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.pb_editor_faceview_height)));
            this.aqH.setVisibility(8);
            com.baidu.tbadk.core.util.aw.h(this.aqH, com.baidu.tieba.s.record_voice_container_bg);
            if (this.aqI != null) {
                this.aqH.setCallback(this.aqI);
            }
            if (this.RG != null) {
                this.RG.handleAction(54, null);
            }
        }
    }

    private void Bk() {
        if (this.aqG == null) {
            this.aqG = new EmotionTabHost(this.mContext);
            this.Hl.addView(this.aqG, new LinearLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.pb_editor_faceview_height)));
            this.aqG.setVisibility(8);
            this.aqG.setShowBigEmotion(!this.aqX);
            this.aqG.onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
            this.aqG.setOnDataSelected(new m(this));
        }
    }

    private void Bl() {
        if (this.aqL == null) {
            com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.editor_tool_container_image, this.Hl);
            this.aqL = (DragContainer) findViewById(com.baidu.tieba.v.muti_image_upload);
            this.aqM = (DragLayer) findViewById(com.baidu.tieba.v.muti_image_upload_draglayer);
            this.aqN = (DragHorizonScrollView) findViewById(com.baidu.tieba.v.muti_image_upload_dragscrollview);
            com.baidu.tieba.img.view.a aVar = new com.baidu.tieba.img.view.a(getContext());
            aVar.a(this.aqM);
            aVar.a((com.baidu.tieba.img.view.g) this.aqN);
            aVar.a((com.baidu.tieba.img.view.f) this.aqN);
            this.aqS = (TextView) findViewById(com.baidu.tieba.v.muti_image_tips);
            this.aqY = getResources().getDimensionPixelSize(com.baidu.tieba.t.editor_muti_image_upload_scrollview_paddingleft);
            this.padding = getResources().getDimensionPixelSize(com.baidu.tieba.t.default_gap_24);
            this.aqN.setAddView(ep(7));
            this.aqN.setOnSwapDataListener(this);
            this.aqN.setMaxItemNum(10);
            if (this.arc == null) {
                this.arc = new com.baidu.tbadk.img.e(this.mContext);
            }
        }
    }

    private void Bm() {
        if (this.aqO == null) {
            com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.editor_tool_container_baobao, this.Hl);
            this.aqO = (DragContainer) findViewById(com.baidu.tieba.v.baobao_image_upload);
            this.aqP = (DragLayer) findViewById(com.baidu.tieba.v.baobao_image_upload_draglayer);
            this.aqQ = (DragHorizonScrollView) findViewById(com.baidu.tieba.v.baobao_image_upload_dragscrollview);
            this.aqR = (TextView) findViewById(com.baidu.tieba.v.baobao_image_tips);
            com.baidu.tieba.img.view.a aVar = new com.baidu.tieba.img.view.a(getContext());
            aVar.a(this.aqP);
            aVar.a((com.baidu.tieba.img.view.g) this.aqQ);
            aVar.a((com.baidu.tieba.img.view.f) this.aqQ);
            this.aqQ.setAddView(ep(48));
            this.aqQ.setOnSwapDataListener(this);
            this.aqQ.setMaxItemNum(1);
            this.aqQ.setCenterStart(true);
            if (this.arc == null) {
                this.arc = new com.baidu.tbadk.img.e(this.mContext);
            }
        }
    }

    private void Bn() {
        if (this.aqT == null) {
            this.aqT = new ar(this.mContext);
            this.Hl.addView(this.aqT, new LinearLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.pb_editor_faceview_height)));
            this.aqT.setVisibility(8);
            this.aqT.onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
            this.aqT.setOnDataSelected(new n(this));
        }
    }

    protected void Bo() {
        if (this.mContext instanceof BaseActivity) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2010041, this.aqZ);
            customResponsedMessage.setOrginalMessage(new CustomMessage(2010041, ((BaseActivity) this.mContext).getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessageToUI(customResponsedMessage);
        } else if (this.mContext instanceof BaseFragmentActivity) {
            CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(2010041, this.aqZ);
            customResponsedMessage2.setOrginalMessage(new CustomMessage(2010041, ((BaseFragmentActivity) this.mContext).getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessageToUI(customResponsedMessage2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Bp() {
        if (BP()) {
            this.aqZ.ask = 1;
        } else {
            this.aqZ.ask = 0;
        }
        if (this.ara != null && this.ara.getChosedFiles() != null && this.ara.getChosedFiles().size() > 0) {
            this.aqZ.asj = this.ara.getChosedFiles().size();
        } else {
            this.aqZ.asj = 0;
        }
        if (this.arb != null && this.arb.getChosedFiles() != null && this.arb.getChosedFiles().size() > 0) {
            this.aqZ.asl = this.arb.getChosedFiles().size();
        } else {
            this.aqZ.asl = 0;
        }
        Bo();
    }

    public void setHideBaobao(boolean z) {
        this.SY = z;
        if (this.aqF != null) {
            this.aqF.setHideBaobao(z);
            if (z && com.baidu.tieba.e.a.adJ()) {
                this.aqF.rM();
            }
        }
    }

    public void setFrom(int i) {
        if (this.aqG != null) {
            this.aqG.setFrom(i);
        }
    }

    protected void Bq() {
        Bk();
        this.aqK.setVisibility(0);
        if (TbadkApplication.m251getInst().getKeyboardHeight() > 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aqG.getLayoutParams();
            layoutParams.height = TbadkApplication.m251getInst().getKeyboardHeight();
            this.aqG.setLayoutParams(layoutParams);
        }
        this.aqG.setVisibility(0);
    }

    protected void Br() {
        if (this.aqG != null) {
            this.aqG.setVisibility(8);
        }
    }

    public void Bs() {
        View recordButton;
        if (this.aqF != null && (recordButton = this.aqF.getRecordButton()) != null) {
            recordButton.setVisibility(4);
        }
    }

    public void Bt() {
        View recordButton;
        if (this.aqF != null && (recordButton = this.aqF.getRecordButton()) != null) {
            recordButton.setVisibility(0);
        }
    }

    protected void Bu() {
        Bj();
        this.aqK.setVisibility(0);
        if (TbadkApplication.m251getInst().isKeyboardHeightCanUsed()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aqH.getLayoutParams();
            layoutParams.height = TbadkApplication.m251getInst().getKeyboardHeight();
            this.aqH.setLayoutParams(layoutParams);
        }
        this.aqH.setVisibility(0);
    }

    protected void Bv() {
        if (this.aqH != null) {
            this.aqH.setVisibility(8);
        }
    }

    protected void Bw() {
        this.aqK.setVisibility(0);
        if (TbadkApplication.m251getInst().isKeyboardHeightCanUsed()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aqF.getLayoutParams();
            layoutParams.height = TbadkApplication.m251getInst().getKeyboardHeight();
            this.aqF.setLayoutParams(layoutParams);
        }
        this.aqF.setVisibility(0);
    }

    public void Bx() {
        if (this.aqL != null) {
            this.aqL.setVisibility(8);
        }
    }

    public void By() {
        Bl();
        this.aqK.setVisibility(0);
        if (TbadkApplication.m251getInst().isKeyboardHeightCanUsed()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aqL.getLayoutParams();
            layoutParams.height = TbadkApplication.m251getInst().getKeyboardHeight();
            this.aqL.setLayoutParams(layoutParams);
        }
        this.aqL.setVisibility(0);
    }

    public void Bz() {
        if (this.aqO != null) {
            this.aqO.setVisibility(8);
        }
    }

    public void rM() {
        this.aqF.rM();
    }

    public void di(String str) {
        if (this.aqF != null) {
            this.aqF.di(str);
        }
    }

    public void rF() {
        if (this.aqF != null) {
            this.aqF.rF();
        }
    }

    public void rN() {
        if (this.aqF != null) {
            this.aqF.rN();
        }
    }

    public void rO() {
        if (this.aqF != null) {
            this.aqF.rO();
        }
    }

    public boolean rJ() {
        if (this.aqF == null) {
            return false;
        }
        return this.aqF.rJ();
    }

    public void rK() {
        if (this.aqF != null) {
            this.aqF.rK();
        }
    }

    public void rL() {
        if (this.aqF != null) {
            this.aqF.rL();
        }
    }

    public void BA() {
        Bm();
        this.aqK.setVisibility(0);
        if (TbadkApplication.m251getInst().isKeyboardHeightCanUsed()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aqO.getLayoutParams();
            layoutParams.height = TbadkApplication.m251getInst().getKeyboardHeight();
            this.aqO.setLayoutParams(layoutParams);
        }
        this.aqO.setVisibility(0);
        if (TextUtils.isEmpty(this.aqR.getText())) {
            this.aqR.setText(com.baidu.tieba.y.baobao_remind);
        }
    }

    protected void hideMore() {
        this.aqF.setVisibility(8);
    }

    protected void BB() {
        Bn();
        this.aqK.setVisibility(0);
        if (TbadkApplication.m251getInst().isKeyboardHeightCanUsed()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aqT.getLayoutParams();
            layoutParams.height = TbadkApplication.m251getInst().getKeyboardHeight();
            this.aqT.setLayoutParams(layoutParams);
        }
        this.aqT.setVisibility(0);
    }

    protected void BC() {
        if (this.aqT != null) {
            this.aqT.setVisibility(8);
        }
    }

    public void v(View view) {
        if (view != null) {
            com.baidu.adp.lib.util.m.c(this.mContext, view);
            this.aqU = true;
        }
    }

    public void w(View view) {
        if (view != null) {
            com.baidu.adp.lib.util.m.b(this.mContext, view);
            this.aqU = false;
        }
    }

    public boolean BD() {
        return this.aqF.getVisibility() == 0 || (this.aqH != null && this.aqH.getVisibility() == 0) || ((this.aqG != null && this.aqG.getVisibility() == 0) || ((this.aqL != null && this.aqL.getVisibility() == 0) || ((this.aqT != null && this.aqT.getVisibility() == 0) || (this.aqO != null && this.aqO.getVisibility() == 0))));
    }

    public void BE() {
        BF();
        w(this.aqJ);
    }

    public void BF() {
        this.aqK.setVisibility(8);
        hideMore();
        Bv();
        Br();
        Bx();
        BC();
        Bz();
    }

    public void BG() {
        if (TbadkApplication.m251getInst().isKeyboardHeightCanUsed()) {
            if (this.aqF != null && this.aqF.getVisibility() == 0) {
                Bw();
            } else if (this.aqG != null && this.aqG.getVisibility() == 0) {
                Bq();
            } else if (this.aqH != null && this.aqH.getVisibility() == 0) {
                Bu();
            } else if (this.aqL != null && this.aqL.getVisibility() == 0) {
                By();
            } else if (this.aqT != null && this.aqT.getVisibility() == 0) {
                BB();
            } else if (this.aqO != null && this.aqO.getVisibility() == 0) {
                BA();
            }
        }
    }

    public void BH() {
        BE();
        Bw();
    }

    public void BI() {
        BE();
        Bq();
    }

    public void BJ() {
        BE();
        Bu();
    }

    public void BK() {
        BE();
        By();
    }

    public void BL() {
        BE();
        BB();
    }

    public void BM() {
        BE();
        BA();
    }

    public void x(View view) {
        if (!this.aqU) {
            BE();
            this.aqJ = view;
            v(view);
        }
    }

    public boolean BN() {
        BaseAdapter adapter;
        return (this.aqN == null || (adapter = this.aqN.getAdapter()) == null || adapter.getCount() <= 0) ? false : true;
    }

    public boolean BO() {
        BaseAdapter adapter;
        return (this.aqQ == null || (adapter = this.aqQ.getAdapter()) == null || adapter.getCount() <= 0) ? false : true;
    }

    public boolean BP() {
        VoiceData.VoiceModel voiceModel;
        return (this.aqH == null || (voiceModel = this.aqH.getVoiceModel()) == null || voiceModel.getId() == null || voiceModel.getId().length() <= 0) ? false : true;
    }

    public VoiceData.VoiceModel getAudioData() {
        if (this.aqH == null) {
            return null;
        }
        return this.aqH.getVoiceModel();
    }

    public void BQ() {
        if (this.aqI != null) {
            this.aqI.BW();
        }
    }

    public void setAudioData(VoiceData.VoiceModel voiceModel) {
        if (this.aqH != null && voiceModel != null) {
            this.aqH.d(voiceModel);
        }
    }

    public void BR() {
        if (this.aqH != null) {
            this.aqH.afd();
        }
    }

    public void clearData() {
        if (this.aqH != null) {
            this.aqH.reset();
            setImage(null);
            this.aqF.rM();
        }
    }

    public void BS() {
        if (this.aqH != null) {
            this.aqH.onStopingRecorder();
        }
    }

    public void BT() {
        BS();
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        this.RG = new o(this, wVar);
        this.aqV.setPositiveButton(com.baidu.tieba.y.editor_dialog_yes, new p(this));
        this.aqF.setOnClickListener(new q(this));
        this.aqI = new r(this);
        if (this.aqH != null) {
            this.aqH.setCallback(this.aqI);
        }
    }

    public boolean BU() {
        return this.aqU;
    }

    public void setImage(Bitmap bitmap) {
        if (bitmap == null) {
            this.aqF.setmImagetype(0);
        }
        this.aqF.setImage(bitmap);
    }

    public void au(boolean z) {
        this.aqX = z;
        this.aqF.au(z);
        if (this.aqG != null) {
            this.aqG.setShowBigEmotion(!z);
        }
    }

    public void rQ() {
        this.aqF.rQ();
    }

    public void onChangeSkinType(int i) {
        if (this.aqG != null) {
            this.aqG.onChangeSkinType(i);
        }
        this.aqF.onChangeSkinType(i);
        if (this.aqT != null) {
            this.aqT.onChangeSkinType(i);
        }
        if (this.aqH != null) {
            com.baidu.tbadk.core.util.aw.h(this.aqH, com.baidu.tieba.s.record_voice_container_bg);
        }
    }

    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        Bl();
        this.ara = writeImagesInfo;
        this.aqN.a(new t(this, writeImagesInfo), z);
        int maxItemNum = this.aqN.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (!com.baidu.tieba.aj.wm().wX() && size > 1) {
            this.aqS.setText(com.baidu.tieba.y.editor_mutiiamge_drag_tip);
            com.baidu.tieba.aj.wm().be(true);
        } else {
            this.aqS.setText(getResources().getString(com.baidu.tieba.y.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
        }
        if (size > 0) {
            this.aqF.di(new StringBuilder(String.valueOf(size)).toString());
        } else {
            this.aqF.rF();
        }
        this.RG.handleAction(13, null);
        Bp();
    }

    public void setBaobaoUris(WriteImagesInfo writeImagesInfo) {
        Bm();
        this.arb = writeImagesInfo;
        this.aqQ.a((BaseAdapter) new t(this, this.arb), false);
        this.RG.handleAction(51, null);
        if (this.arb.size() > 0) {
            this.aqF.dk("1");
        } else {
            this.aqF.rM();
        }
        this.RG.handleAction(51, null);
        Bp();
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

    public void BV() {
        if (this.aqN != null) {
            this.aqN.notifyDataSetChanged();
        }
        if (this.aqQ != null) {
            this.aqQ.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.img.view.d
    public void G(int i, int i2) {
        if (i != i2 && this.ara != null && this.ara.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.ara.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void refresh() {
        if (this.aqX) {
            this.aqF.rI();
        } else if (TextUtils.isEmpty(TbadkApplication.m251getInst().getDefaultBubble()) && !this.aqX) {
            this.aqF.rI();
        } else {
            this.aqF.rH();
        }
    }
}
