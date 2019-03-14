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
    private LinearLayout ffC;
    private TextView gaK;
    private ImageView gdP;
    private LinearLayout gdQ;
    private LinearLayout gdR;
    private OfficialSecondMenuPopupWindow gdS;
    private a[] gdT;
    private boolean gdU;

    public OfficialBarMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.gdU = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        String string = talkableActivity.getPageContext().getString(d.j.forum_detail_title);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.group_info_btn, talkableActivity);
            this.mNavigationBar.showBottomLine();
            this.gaK = (TextView) this.mBtnGroupInfo.findViewById(d.g.group_info_btn_txt);
            this.gaK.setText(string);
        }
        this.ffC = (LinearLayout) ((ViewStub) talkableActivity.findViewById(d.g.official_bar_memu_stub)).inflate();
        this.ffC.setVisibility(0);
        this.gdP = (ImageView) this.ffC.findViewById(d.g.official_bar_toggle_button);
        this.gdP.setVisibility(0);
        this.gdT = new a[3];
        a aVar = new a();
        aVar.gdY = false;
        aVar.gdZ = (LinearLayout) this.ffC.findViewById(d.g.menu_frist);
        aVar.gea = (TextView) this.ffC.findViewById(d.g.menu_frist_text);
        aVar.geb = (ImageView) this.ffC.findViewById(d.g.menu_frist_tip);
        this.gdT[0] = aVar;
        a aVar2 = new a();
        aVar2.gdY = false;
        aVar2.gdZ = (LinearLayout) this.ffC.findViewById(d.g.menu_second);
        aVar2.gea = (TextView) this.ffC.findViewById(d.g.menu_second_text);
        aVar2.geb = (ImageView) this.ffC.findViewById(d.g.menu_second_tip);
        this.gdT[1] = aVar2;
        a aVar3 = new a();
        aVar3.gdY = false;
        aVar3.gdZ = (LinearLayout) this.ffC.findViewById(d.g.menu_third);
        aVar3.gea = (TextView) this.ffC.findViewById(d.g.menu_third_text);
        aVar3.geb = (ImageView) this.ffC.findViewById(d.g.menu_third_tip);
        this.gdT[2] = aVar3;
        for (int i = 0; i < 3; i++) {
            this.gdT[i].gdZ.setOnClickListener(talkableActivity);
        }
        this.gdQ = (LinearLayout) ((ViewStub) talkableActivity.findViewById(d.g.official_bar_memu_down_line)).inflate();
        this.gdQ.setVisibility(0);
        this.gdR = (LinearLayout) ((ViewStub) talkableActivity.findViewById(d.g.official_bar_menu_loading)).inflate();
        this.gdR.setVisibility(8);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.gdP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OfficialBarMsglistView.this.kM(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsglist(MsglistActivity msglistActivity) {
        super.initMsglist(msglistActivity);
        this.gdS = new OfficialSecondMenuPopupWindow(msglistActivity.getPageContext().getPageActivity());
        getListMain().addView(this.gdS);
        this.gdS.setVisibility(8);
        this.gdS.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
        this.gdU = true;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initMsgSend(TalkableActivity talkableActivity) {
        this.mTool = new EditorTools(talkableActivity.getActivity());
        this.mTool.setBarMaxLauCount(1);
        this.mTool.setMoreButtonAtEnd(true);
        this.mTool.setDeskBackgroundColorId(d.C0277d.cp_bg_line_c);
        this.mTool.setMoreDeskBgColorId(d.C0277d.cp_bg_line_c);
        this.mTool.eH(true);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001301, k.class, talkableActivity.getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.mSendTool = (k) runTask.getData();
            if (this.mSendTool.ciu != null && (this.mSendTool.ciu instanceof ISendVoiceView)) {
                this.mSendVoiceView = (ISendVoiceView) this.mSendTool.ciu;
                if (this.mSendVoiceView instanceof View) {
                    ((View) this.mSendVoiceView).setOnTouchListener(this.mContext);
                }
            }
            this.mSendTool.cjk = 1;
            this.mTool.b(this.mSendTool);
        }
        this.mTool.b(new com.baidu.tbadk.editortools.imagetool.d(talkableActivity.getActivity(), 2));
        ArrayList arrayList = new ArrayList();
        arrayList.add(6);
        arrayList.add(10);
        arrayList.add(5);
        this.mTool.ab(arrayList);
        k jw = this.mTool.jw(5);
        if (jw != null) {
            jw.cjk = 3;
            jw.cji = d.f.btn_pb_add_expression;
        }
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(talkableActivity.getActivity(), false);
        aVar.setIsOnlyLocalEmotion(true);
        if (aVar.ciu != null && (aVar.ciu instanceof EditText)) {
            ((EditText) aVar.ciu).setTextSize(0, talkableActivity.getActivity().getResources().getDimensionPixelSize(d.e.ds34));
        }
        this.mTool.b(aVar);
        com.baidu.tbadk.editortools.sendtool.a aVar2 = new com.baidu.tbadk.editortools.sendtool.a(talkableActivity.getActivity());
        aVar2.setText(d.j.send_msg);
        this.mTool.b(aVar2);
        if (this.gdU) {
            this.mTool.b(new com.baidu.tieba.im.chat.officialBar.a(talkableActivity.getActivity()));
        }
        this.mTool.alT();
        this.mInputControl.addView(this.mTool, new ViewGroup.LayoutParams(-1, -2));
        this.mTool.setActionListener(24, this.mActionListener);
        this.mTool.setActionListener(8, this.mActionListener);
        this.mTool.setActionListener(4, this.mActionListener);
        this.mTool.setActionListener(14, this.mActionListener);
        if (TbadkCoreApplication.getInst().isFaceShopNew()) {
            this.mTool.b(new com.baidu.tbadk.editortools.a(2, 5, "N"));
        }
        if (this.gdU) {
            this.mTool.setActionListener(30, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.2
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar3) {
                    OfficialBarMsglistView.this.kM(true);
                }
            });
        }
    }

    public OfficialSecondMenuPopupWindow bqu() {
        return this.gdS;
    }

    public void Q(boolean z, boolean z2) {
        if (this.gdU != z) {
            if (!this.gdU) {
                this.mTool.eJ(false);
                return;
            }
            this.ffC.setVisibility(0);
            if (this.mTool != null) {
                this.mTool.hide();
            }
            this.gdQ.setVisibility(0);
            return;
        }
        this.gdU = !z;
        if (z) {
            this.ffC.setVisibility(8);
            if (this.mTool != null) {
                this.mInputControl.removeView(this.mTool);
                initMsgSend(this.mContext);
                this.mTool.onChangeSkinType(0);
                if (z2) {
                    this.mTool.eJ(true);
                } else {
                    this.mTool.eJ(false);
                }
            }
            this.gdQ.setVisibility(8);
            return;
        }
        if (this.mTool != null) {
            this.mInputControl.removeView(this.mTool);
            initMsgSend(this.mContext);
            this.mTool.onChangeSkinType(0);
        }
        this.ffC.setVisibility(0);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.gdQ.setVisibility(0);
    }

    public a[] bqv() {
        return this.gdT;
    }

    public void cJ(List<com.baidu.tieba.im.data.b> list) {
        if (list != null && list.size() == 3) {
            for (int i = 0; i < 3; i++) {
                com.baidu.tieba.im.data.b bVar = list.get(i);
                this.gdT[i].gea.setText(bVar.getName());
                if (bVar.brZ() != 0) {
                    this.gdT[i].geb.setVisibility(8);
                }
            }
        }
    }

    public void kL(boolean z) {
        this.gdR.setVisibility(z ? 0 : 8);
    }

    public void kM(final boolean z) {
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
                    OfficialBarMsglistView.this.ffC.setVisibility(0);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.hide();
                    }
                } else {
                    OfficialBarMsglistView.this.ffC.setVisibility(8);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.qT();
                    }
                    for (int i = 0; i < 3; i++) {
                        a aVar = OfficialBarMsglistView.this.gdT[i];
                        if (aVar.gdY) {
                            aVar.gdY = false;
                            OfficialBarMsglistView.this.C(i, aVar.gdY);
                            OfficialBarMsglistView.this.gdS.aXu();
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

    public void C(int i, boolean z) {
        a aVar = this.gdT[i];
        if (z) {
            aVar.geb.setImageResource(d.f.icon_bottombar_arrow_s);
            aVar.gea.setTextColor(this.mContext.getResources().getColor(d.C0277d.cp_link_tip_a));
            return;
        }
        aVar.geb.setImageResource(d.f.icon_bottombar_arrow_n);
        aVar.gea.setTextColor(this.mContext.getResources().getColor(d.C0277d.cp_cont_f));
    }

    public int bW(View view) {
        for (int i = 0; i < 3; i++) {
            if (view == this.gdT[i].gdZ) {
                return i;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a {
        boolean gdY;
        LinearLayout gdZ;
        TextView gea;
        ImageView geb;

        a() {
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return false;
    }

    public void tC(int i) {
        if (this.gaK != null) {
            this.gaK.setText(i);
        }
    }

    public void bqw() {
        if (this.mLayBottom != null) {
            this.mLayBottom.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.d(this.gaK, d.C0277d.cp_link_tip_a, 1);
    }
}
