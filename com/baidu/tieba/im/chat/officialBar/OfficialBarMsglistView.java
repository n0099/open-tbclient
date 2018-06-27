package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.ISendVoiceView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.im.view.OfficialSecondMenuPopupWindow;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class OfficialBarMsglistView extends CommonPersonalMsglistView {
    private LinearLayout dpm;
    private TextView ega;
    private ImageView ejf;
    private LinearLayout ejg;
    private LinearLayout ejh;
    private OfficialSecondMenuPopupWindow eji;
    private a[] ejj;
    private boolean ejk;

    public OfficialBarMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.ejk = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        String string = talkableActivity.getPageContext().getString(d.k.forum_detail_title);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.group_info_btn, talkableActivity);
            this.mNavigationBar.showBottomLine();
            this.ega = (TextView) this.mBtnGroupInfo.findViewById(d.g.group_info_btn_txt);
            this.ega.setText(string);
        }
        this.dpm = (LinearLayout) ((ViewStub) talkableActivity.findViewById(d.g.official_bar_memu_stub)).inflate();
        this.dpm.setVisibility(0);
        this.ejf = (ImageView) this.dpm.findViewById(d.g.official_bar_toggle_button);
        this.ejf.setVisibility(0);
        this.ejj = new a[3];
        a aVar = new a();
        aVar.ejo = false;
        aVar.ejp = (LinearLayout) this.dpm.findViewById(d.g.menu_frist);
        aVar.ejq = (TextView) this.dpm.findViewById(d.g.menu_frist_text);
        aVar.ejr = (ImageView) this.dpm.findViewById(d.g.menu_frist_tip);
        this.ejj[0] = aVar;
        a aVar2 = new a();
        aVar2.ejo = false;
        aVar2.ejp = (LinearLayout) this.dpm.findViewById(d.g.menu_second);
        aVar2.ejq = (TextView) this.dpm.findViewById(d.g.menu_second_text);
        aVar2.ejr = (ImageView) this.dpm.findViewById(d.g.menu_second_tip);
        this.ejj[1] = aVar2;
        a aVar3 = new a();
        aVar3.ejo = false;
        aVar3.ejp = (LinearLayout) this.dpm.findViewById(d.g.menu_third);
        aVar3.ejq = (TextView) this.dpm.findViewById(d.g.menu_third_text);
        aVar3.ejr = (ImageView) this.dpm.findViewById(d.g.menu_third_tip);
        this.ejj[2] = aVar3;
        for (int i = 0; i < 3; i++) {
            this.ejj[i].ejp.setOnClickListener(talkableActivity);
        }
        this.ejg = (LinearLayout) ((ViewStub) talkableActivity.findViewById(d.g.official_bar_memu_down_line)).inflate();
        this.ejg.setVisibility(0);
        this.ejh = (LinearLayout) ((ViewStub) talkableActivity.findViewById(d.g.official_bar_menu_loading)).inflate();
        this.ejh.setVisibility(8);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.ejf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OfficialBarMsglistView.this.he(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsglist(MsglistActivity msglistActivity) {
        super.initMsglist(msglistActivity);
        this.eji = new OfficialSecondMenuPopupWindow(msglistActivity.getPageContext().getPageActivity());
        getListMain().addView(this.eji);
        this.eji.setVisibility(8);
        this.eji.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
        this.ejk = true;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initMsgSend(TalkableActivity talkableActivity) {
        this.mTool = new EditorTools(talkableActivity.getActivity());
        this.mTool.setBarMaxLauCount(1);
        this.mTool.setMoreButtonAtEnd(true);
        this.mTool.setDeskBackgroundColorId(d.C0142d.cp_bg_line_c);
        this.mTool.setMoreDeskBgColorId(d.C0142d.cp_bg_line_c);
        this.mTool.bE(true);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001301, k.class, talkableActivity.getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.mSendTool = (k) runTask.getData();
            if (this.mSendTool.aMf != null && (this.mSendTool.aMf instanceof ISendVoiceView)) {
                this.mSendVoiceView = (ISendVoiceView) this.mSendTool.aMf;
                if (this.mSendVoiceView instanceof View) {
                    ((View) this.mSendVoiceView).setOnTouchListener(this.mContext);
                }
            }
            this.mSendTool.aMU = 1;
            this.mTool.b(this.mSendTool);
        }
        this.mTool.b(new com.baidu.tbadk.editortools.imagetool.d(talkableActivity.getActivity(), 2));
        ArrayList arrayList = new ArrayList();
        arrayList.add(6);
        arrayList.add(10);
        arrayList.add(5);
        this.mTool.G(arrayList);
        k eN = this.mTool.eN(5);
        if (eN != null) {
            eN.aMU = 3;
            eN.aMS = d.f.btn_pb_add_expression;
        }
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(talkableActivity.getActivity(), false);
        aVar.setIsOnlyLocalEmotion(true);
        if (aVar.aMf != null && (aVar.aMf instanceof EditText)) {
            ((EditText) aVar.aMf).setTextSize(0, talkableActivity.getActivity().getResources().getDimensionPixelSize(d.e.ds34));
        }
        this.mTool.b(aVar);
        com.baidu.tbadk.editortools.sendtool.a aVar2 = new com.baidu.tbadk.editortools.sendtool.a(talkableActivity.getActivity());
        aVar2.setText(d.k.send_msg);
        this.mTool.b(aVar2);
        if (this.ejk) {
            this.mTool.b(new com.baidu.tieba.im.chat.officialBar.a(talkableActivity.getActivity()));
        }
        this.mTool.Hz();
        this.mInputControl.addView(this.mTool, new ViewGroup.LayoutParams(-1, -2));
        this.mTool.setActionListener(24, this.mActionListener);
        this.mTool.setActionListener(8, this.mActionListener);
        this.mTool.setActionListener(4, this.mActionListener);
        this.mTool.setActionListener(14, this.mActionListener);
        if (TbadkCoreApplication.getInst().isFaceShopNew()) {
            this.mTool.b(new com.baidu.tbadk.editortools.a(2, 5, "N"));
        }
        if (this.ejk) {
            this.mTool.setActionListener(30, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.2
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar3) {
                    OfficialBarMsglistView.this.he(true);
                }
            });
        }
    }

    public OfficialSecondMenuPopupWindow aGL() {
        return this.eji;
    }

    public void E(boolean z, boolean z2) {
        if (this.ejk != z) {
            if (!this.ejk) {
                this.mTool.bG(false);
                return;
            }
            this.dpm.setVisibility(0);
            if (this.mTool != null) {
                this.mTool.hide();
            }
            this.ejg.setVisibility(0);
            return;
        }
        this.ejk = !z;
        if (z) {
            this.dpm.setVisibility(8);
            if (this.mTool != null) {
                this.mInputControl.removeView(this.mTool);
                initMsgSend(this.mContext);
                this.mTool.onChangeSkinType(0);
                if (z2) {
                    this.mTool.bG(true);
                } else {
                    this.mTool.bG(false);
                }
            }
            this.ejg.setVisibility(8);
            return;
        }
        if (this.mTool != null) {
            this.mInputControl.removeView(this.mTool);
            initMsgSend(this.mContext);
            this.mTool.onChangeSkinType(0);
        }
        this.dpm.setVisibility(0);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.ejg.setVisibility(0);
    }

    public a[] aGM() {
        return this.ejj;
    }

    public void cd(List<com.baidu.tieba.im.data.b> list) {
        if (list != null && list.size() == 3) {
            for (int i = 0; i < 3; i++) {
                com.baidu.tieba.im.data.b bVar = list.get(i);
                this.ejj[i].ejq.setText(bVar.getName());
                if (bVar.aIq() != 0) {
                    this.ejj[i].ejr.setVisibility(8);
                }
            }
        }
    }

    public void hd(boolean z) {
        this.ejh.setVisibility(z ? 0 : 8);
    }

    public void he(final boolean z) {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext.getPageContext().getPageActivity(), d.a.parent_menu_up);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mContext.getPageContext().getPageActivity(), d.a.parent_menu_down);
        loadAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (z) {
                    OfficialBarMsglistView.this.dpm.setVisibility(0);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.hide();
                    }
                } else {
                    OfficialBarMsglistView.this.dpm.setVisibility(8);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.oD();
                    }
                    for (int i = 0; i < 3; i++) {
                        a aVar = OfficialBarMsglistView.this.ejj[i];
                        if (aVar.ejo) {
                            aVar.ejo = false;
                            OfficialBarMsglistView.this.w(i, aVar.ejo);
                            OfficialBarMsglistView.this.eji.aqA();
                        }
                    }
                }
                OfficialBarMsglistView.this.getLayoutBottom().startAnimation(loadAnimation);
            }
        });
        sendmsgCloseSoftkey();
        if (isMoreVisible()) {
            hideMore();
        }
        getLayoutBottom().startAnimation(loadAnimation2);
    }

    public void w(int i, boolean z) {
        a aVar = this.ejj[i];
        if (z) {
            aVar.ejr.setImageResource(d.f.icon_bottombar_arrow_s);
            aVar.ejq.setTextColor(this.mContext.getResources().getColor(d.C0142d.cp_link_tip_a));
            return;
        }
        aVar.ejr.setImageResource(d.f.icon_bottombar_arrow_n);
        aVar.ejq.setTextColor(this.mContext.getResources().getColor(d.C0142d.cp_cont_f));
    }

    public int aL(View view) {
        for (int i = 0; i < 3; i++) {
            if (view == this.ejj[i].ejp) {
                return i;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a {
        boolean ejo;
        LinearLayout ejp;
        TextView ejq;
        ImageView ejr;

        a() {
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return false;
    }

    public void nB(int i) {
        if (this.ega != null) {
            this.ega.setText(i);
        }
    }

    public void aGN() {
        if (this.mLayBottom != null) {
            this.mLayBottom.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.c(this.ega, d.C0142d.cp_link_tip_a, 1);
    }
}
