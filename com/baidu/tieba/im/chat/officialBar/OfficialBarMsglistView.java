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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.e;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.ISendVoiceView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.im.view.OfficialSecondMenuPopupWindow;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class OfficialBarMsglistView extends CommonPersonalMsglistView {
    private LinearLayout dHC;
    private TextView eAq;
    private boolean eDA;
    private ImageView eDv;
    private LinearLayout eDw;
    private LinearLayout eDx;
    private OfficialSecondMenuPopupWindow eDy;
    private a[] eDz;

    public OfficialBarMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.eDA = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        String string = talkableActivity.getPageContext().getString(e.j.forum_detail_title);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.group_info_btn, talkableActivity);
            this.mNavigationBar.showBottomLine();
            this.eAq = (TextView) this.mBtnGroupInfo.findViewById(e.g.group_info_btn_txt);
            this.eAq.setText(string);
        }
        this.dHC = (LinearLayout) ((ViewStub) talkableActivity.findViewById(e.g.official_bar_memu_stub)).inflate();
        this.dHC.setVisibility(0);
        this.eDv = (ImageView) this.dHC.findViewById(e.g.official_bar_toggle_button);
        this.eDv.setVisibility(0);
        this.eDz = new a[3];
        a aVar = new a();
        aVar.eDE = false;
        aVar.eDF = (LinearLayout) this.dHC.findViewById(e.g.menu_frist);
        aVar.eDG = (TextView) this.dHC.findViewById(e.g.menu_frist_text);
        aVar.eDH = (ImageView) this.dHC.findViewById(e.g.menu_frist_tip);
        this.eDz[0] = aVar;
        a aVar2 = new a();
        aVar2.eDE = false;
        aVar2.eDF = (LinearLayout) this.dHC.findViewById(e.g.menu_second);
        aVar2.eDG = (TextView) this.dHC.findViewById(e.g.menu_second_text);
        aVar2.eDH = (ImageView) this.dHC.findViewById(e.g.menu_second_tip);
        this.eDz[1] = aVar2;
        a aVar3 = new a();
        aVar3.eDE = false;
        aVar3.eDF = (LinearLayout) this.dHC.findViewById(e.g.menu_third);
        aVar3.eDG = (TextView) this.dHC.findViewById(e.g.menu_third_text);
        aVar3.eDH = (ImageView) this.dHC.findViewById(e.g.menu_third_tip);
        this.eDz[2] = aVar3;
        for (int i = 0; i < 3; i++) {
            this.eDz[i].eDF.setOnClickListener(talkableActivity);
        }
        this.eDw = (LinearLayout) ((ViewStub) talkableActivity.findViewById(e.g.official_bar_memu_down_line)).inflate();
        this.eDw.setVisibility(0);
        this.eDx = (LinearLayout) ((ViewStub) talkableActivity.findViewById(e.g.official_bar_menu_loading)).inflate();
        this.eDx.setVisibility(8);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.eDv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OfficialBarMsglistView.this.ig(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsglist(MsglistActivity msglistActivity) {
        super.initMsglist(msglistActivity);
        this.eDy = new OfficialSecondMenuPopupWindow(msglistActivity.getPageContext().getPageActivity());
        getListMain().addView(this.eDy);
        this.eDy.setVisibility(8);
        this.eDy.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
        this.eDA = true;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initMsgSend(TalkableActivity talkableActivity) {
        this.mTool = new EditorTools(talkableActivity.getActivity());
        this.mTool.setBarMaxLauCount(1);
        this.mTool.setMoreButtonAtEnd(true);
        this.mTool.setDeskBackgroundColorId(e.d.cp_bg_line_c);
        this.mTool.setMoreDeskBgColorId(e.d.cp_bg_line_c);
        this.mTool.cp(true);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001301, k.class, talkableActivity.getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.mSendTool = (k) runTask.getData();
            if (this.mSendTool.aUL != null && (this.mSendTool.aUL instanceof ISendVoiceView)) {
                this.mSendVoiceView = (ISendVoiceView) this.mSendTool.aUL;
                if (this.mSendVoiceView instanceof View) {
                    ((View) this.mSendVoiceView).setOnTouchListener(this.mContext);
                }
            }
            this.mSendTool.aVA = 1;
            this.mTool.b(this.mSendTool);
        }
        this.mTool.b(new com.baidu.tbadk.editortools.imagetool.d(talkableActivity.getActivity(), 2));
        ArrayList arrayList = new ArrayList();
        arrayList.add(6);
        arrayList.add(10);
        arrayList.add(5);
        this.mTool.w(arrayList);
        k fw = this.mTool.fw(5);
        if (fw != null) {
            fw.aVA = 3;
            fw.aVy = e.f.btn_pb_add_expression;
        }
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(talkableActivity.getActivity(), false);
        aVar.setIsOnlyLocalEmotion(true);
        if (aVar.aUL != null && (aVar.aUL instanceof EditText)) {
            ((EditText) aVar.aUL).setTextSize(0, talkableActivity.getActivity().getResources().getDimensionPixelSize(e.C0200e.ds34));
        }
        this.mTool.b(aVar);
        com.baidu.tbadk.editortools.sendtool.a aVar2 = new com.baidu.tbadk.editortools.sendtool.a(talkableActivity.getActivity());
        aVar2.setText(e.j.send_msg);
        this.mTool.b(aVar2);
        if (this.eDA) {
            this.mTool.b(new com.baidu.tieba.im.chat.officialBar.a(talkableActivity.getActivity()));
        }
        this.mTool.KU();
        this.mInputControl.addView(this.mTool, new ViewGroup.LayoutParams(-1, -2));
        this.mTool.setActionListener(24, this.mActionListener);
        this.mTool.setActionListener(8, this.mActionListener);
        this.mTool.setActionListener(4, this.mActionListener);
        this.mTool.setActionListener(14, this.mActionListener);
        if (TbadkCoreApplication.getInst().isFaceShopNew()) {
            this.mTool.b(new com.baidu.tbadk.editortools.a(2, 5, "N"));
        }
        if (this.eDA) {
            this.mTool.setActionListener(30, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.2
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar3) {
                    OfficialBarMsglistView.this.ig(true);
                }
            });
        }
    }

    public OfficialSecondMenuPopupWindow aMK() {
        return this.eDy;
    }

    public void J(boolean z, boolean z2) {
        if (this.eDA != z) {
            if (!this.eDA) {
                this.mTool.cr(false);
                return;
            }
            this.dHC.setVisibility(0);
            if (this.mTool != null) {
                this.mTool.hide();
            }
            this.eDw.setVisibility(0);
            return;
        }
        this.eDA = !z;
        if (z) {
            this.dHC.setVisibility(8);
            if (this.mTool != null) {
                this.mInputControl.removeView(this.mTool);
                initMsgSend(this.mContext);
                this.mTool.onChangeSkinType(0);
                if (z2) {
                    this.mTool.cr(true);
                } else {
                    this.mTool.cr(false);
                }
            }
            this.eDw.setVisibility(8);
            return;
        }
        if (this.mTool != null) {
            this.mInputControl.removeView(this.mTool);
            initMsgSend(this.mContext);
            this.mTool.onChangeSkinType(0);
        }
        this.dHC.setVisibility(0);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.eDw.setVisibility(0);
    }

    public a[] aML() {
        return this.eDz;
    }

    public void cr(List<com.baidu.tieba.im.data.b> list) {
        if (list != null && list.size() == 3) {
            for (int i = 0; i < 3; i++) {
                com.baidu.tieba.im.data.b bVar = list.get(i);
                this.eDz[i].eDG.setText(bVar.getName());
                if (bVar.aOp() != 0) {
                    this.eDz[i].eDH.setVisibility(8);
                }
            }
        }
    }

    /* renamed from: if  reason: not valid java name */
    public void m19if(boolean z) {
        this.eDx.setVisibility(z ? 0 : 8);
    }

    public void ig(final boolean z) {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext.getPageContext().getPageActivity(), e.a.parent_menu_up);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mContext.getPageContext().getPageActivity(), e.a.parent_menu_down);
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
                    OfficialBarMsglistView.this.dHC.setVisibility(0);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.hide();
                    }
                } else {
                    OfficialBarMsglistView.this.dHC.setVisibility(8);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.pO();
                    }
                    for (int i = 0; i < 3; i++) {
                        a aVar = OfficialBarMsglistView.this.eDz[i];
                        if (aVar.eDE) {
                            aVar.eDE = false;
                            OfficialBarMsglistView.this.w(i, aVar.eDE);
                            OfficialBarMsglistView.this.eDy.avJ();
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
        a aVar = this.eDz[i];
        if (z) {
            aVar.eDH.setImageResource(e.f.icon_bottombar_arrow_s);
            aVar.eDG.setTextColor(this.mContext.getResources().getColor(e.d.cp_link_tip_a));
            return;
        }
        aVar.eDH.setImageResource(e.f.icon_bottombar_arrow_n);
        aVar.eDG.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_f));
    }

    public int be(View view) {
        for (int i = 0; i < 3; i++) {
            if (view == this.eDz[i].eDF) {
                return i;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a {
        boolean eDE;
        LinearLayout eDF;
        TextView eDG;
        ImageView eDH;

        a() {
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return false;
    }

    public void pj(int i) {
        if (this.eAq != null) {
            this.eAq.setText(i);
        }
    }

    public void aMM() {
        if (this.mLayBottom != null) {
            this.mLayBottom.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.c(this.eAq, e.d.cp_link_tip_a, 1);
    }
}
