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
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.ISendVoiceView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.im.view.OfficialSecondMenuPopupWindow;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class OfficialBarMsglistView extends CommonPersonalMsglistView {
    private LinearLayout fBo;
    private ImageView gBW;
    private LinearLayout gBX;
    private LinearLayout gBY;
    private OfficialSecondMenuPopupWindow gBZ;
    private a[] gCa;
    private boolean gCb;
    private TextView gyU;

    public OfficialBarMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.gCb = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        String string = talkableActivity.getPageContext().getString(R.string.forum_detail_title);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_info_btn, talkableActivity);
            this.mNavigationBar.showBottomLine();
            this.gyU = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.gyU.setText(string);
        }
        this.fBo = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_stub)).inflate();
        this.fBo.setVisibility(0);
        this.gBW = (ImageView) this.fBo.findViewById(R.id.official_bar_toggle_button);
        this.gBW.setVisibility(0);
        this.gCa = new a[3];
        a aVar = new a();
        aVar.gCf = false;
        aVar.gCg = (LinearLayout) this.fBo.findViewById(R.id.menu_frist);
        aVar.gCh = (TextView) this.fBo.findViewById(R.id.menu_frist_text);
        aVar.gCi = (ImageView) this.fBo.findViewById(R.id.menu_frist_tip);
        this.gCa[0] = aVar;
        a aVar2 = new a();
        aVar2.gCf = false;
        aVar2.gCg = (LinearLayout) this.fBo.findViewById(R.id.menu_second);
        aVar2.gCh = (TextView) this.fBo.findViewById(R.id.menu_second_text);
        aVar2.gCi = (ImageView) this.fBo.findViewById(R.id.menu_second_tip);
        this.gCa[1] = aVar2;
        a aVar3 = new a();
        aVar3.gCf = false;
        aVar3.gCg = (LinearLayout) this.fBo.findViewById(R.id.menu_third);
        aVar3.gCh = (TextView) this.fBo.findViewById(R.id.menu_third_text);
        aVar3.gCi = (ImageView) this.fBo.findViewById(R.id.menu_third_tip);
        this.gCa[2] = aVar3;
        for (int i = 0; i < 3; i++) {
            this.gCa[i].gCg.setOnClickListener(talkableActivity);
        }
        this.gBX = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_down_line)).inflate();
        this.gBX.setVisibility(0);
        this.gBY = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_menu_loading)).inflate();
        this.gBY.setVisibility(8);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.gBW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OfficialBarMsglistView.this.lQ(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsglist(MsglistActivity msglistActivity) {
        super.initMsglist(msglistActivity);
        this.gBZ = new OfficialSecondMenuPopupWindow(msglistActivity.getPageContext().getPageActivity());
        getListMain().addView(this.gBZ);
        this.gBZ.setVisibility(8);
        this.gBZ.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
        this.gCb = true;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initMsgSend(TalkableActivity talkableActivity) {
        this.mTool = new EditorTools(talkableActivity.getActivity());
        this.mTool.setBarMaxLauCount(1);
        this.mTool.setMoreButtonAtEnd(true);
        this.mTool.setDeskBackgroundColorId(R.color.cp_bg_line_c);
        this.mTool.setMoreDeskBgColorId(R.color.cp_bg_line_c);
        this.mTool.fh(true);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001301, k.class, talkableActivity.getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.mSendTool = (k) runTask.getData();
            if (this.mSendTool.csa != null && (this.mSendTool.csa instanceof ISendVoiceView)) {
                this.mSendVoiceView = (ISendVoiceView) this.mSendTool.csa;
                if (this.mSendVoiceView instanceof View) {
                    ((View) this.mSendVoiceView).setOnTouchListener(this.mContext);
                }
            }
            this.mSendTool.csQ = 1;
            this.mTool.b(this.mSendTool);
        }
        this.mTool.b(new com.baidu.tbadk.editortools.imagetool.d(talkableActivity.getActivity(), 2));
        ArrayList arrayList = new ArrayList();
        arrayList.add(6);
        arrayList.add(10);
        arrayList.add(5);
        this.mTool.ai(arrayList);
        k kq = this.mTool.kq(5);
        if (kq != null) {
            kq.csQ = 3;
            kq.csO = R.drawable.btn_pb_add_expression;
        }
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(talkableActivity.getActivity(), false);
        aVar.setIsOnlyLocalEmotion(true);
        if (aVar.csa != null && (aVar.csa instanceof EditText)) {
            ((EditText) aVar.csa).setTextSize(0, talkableActivity.getActivity().getResources().getDimensionPixelSize(R.dimen.ds34));
        }
        this.mTool.b(aVar);
        com.baidu.tbadk.editortools.sendtool.a aVar2 = new com.baidu.tbadk.editortools.sendtool.a(talkableActivity.getActivity());
        aVar2.setText(R.string.send_msg);
        this.mTool.b(aVar2);
        if (this.gCb) {
            this.mTool.b(new com.baidu.tieba.im.chat.officialBar.a(talkableActivity.getActivity()));
        }
        this.mTool.asb();
        this.mInputControl.addView(this.mTool, new ViewGroup.LayoutParams(-1, -2));
        this.mTool.setActionListener(24, this.mActionListener);
        this.mTool.setActionListener(8, this.mActionListener);
        this.mTool.setActionListener(4, this.mActionListener);
        this.mTool.setActionListener(14, this.mActionListener);
        if (TbadkCoreApplication.getInst().isFaceShopNew()) {
            this.mTool.b(new com.baidu.tbadk.editortools.a(2, 5, "N"));
        }
        if (this.gCb) {
            this.mTool.setActionListener(30, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.2
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar3) {
                    OfficialBarMsglistView.this.lQ(true);
                }
            });
        }
    }

    public OfficialSecondMenuPopupWindow bAZ() {
        return this.gBZ;
    }

    public void S(boolean z, boolean z2) {
        if (this.gCb != z) {
            if (!this.gCb) {
                this.mTool.fj(false);
                return;
            }
            this.fBo.setVisibility(0);
            if (this.mTool != null) {
                this.mTool.hide();
            }
            this.gBX.setVisibility(0);
            return;
        }
        this.gCb = !z;
        if (z) {
            this.fBo.setVisibility(8);
            if (this.mTool != null) {
                this.mInputControl.removeView(this.mTool);
                initMsgSend(this.mContext);
                this.mTool.onChangeSkinType(0);
                if (z2) {
                    this.mTool.fj(true);
                } else {
                    this.mTool.fj(false);
                }
            }
            this.gBX.setVisibility(8);
            return;
        }
        if (this.mTool != null) {
            this.mInputControl.removeView(this.mTool);
            initMsgSend(this.mContext);
            this.mTool.onChangeSkinType(0);
        }
        this.fBo.setVisibility(0);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.gBX.setVisibility(0);
    }

    public a[] bBa() {
        return this.gCa;
    }

    public void cP(List<com.baidu.tieba.im.data.b> list) {
        if (list != null && list.size() == 3) {
            for (int i = 0; i < 3; i++) {
                com.baidu.tieba.im.data.b bVar = list.get(i);
                this.gCa[i].gCh.setText(bVar.getName());
                if (bVar.bCF() != 0) {
                    this.gCa[i].gCi.setVisibility(8);
                }
            }
        }
    }

    public void lP(boolean z) {
        this.gBY.setVisibility(z ? 0 : 8);
    }

    public void lQ(final boolean z) {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext.getPageContext().getPageActivity(), R.anim.parent_menu_up);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mContext.getPageContext().getPageActivity(), R.anim.parent_menu_down);
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
                    OfficialBarMsglistView.this.fBo.setVisibility(0);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.hide();
                    }
                } else {
                    OfficialBarMsglistView.this.fBo.setVisibility(8);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.qk();
                    }
                    for (int i = 0; i < 3; i++) {
                        a aVar = OfficialBarMsglistView.this.gCa[i];
                        if (aVar.gCf) {
                            aVar.gCf = false;
                            OfficialBarMsglistView.this.J(i, aVar.gCf);
                            OfficialBarMsglistView.this.gBZ.bgT();
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

    public void J(int i, boolean z) {
        a aVar = this.gCa[i];
        if (z) {
            aVar.gCi.setImageResource(R.drawable.icon_bottombar_arrow_s);
            aVar.gCh.setTextColor(this.mContext.getResources().getColor(R.color.cp_link_tip_a));
            return;
        }
        aVar.gCi.setImageResource(R.drawable.icon_bottombar_arrow_n);
        aVar.gCh.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_f));
    }

    public int ch(View view) {
        for (int i = 0; i < 3; i++) {
            if (view == this.gCa[i].gCg) {
                return i;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a {
        boolean gCf;
        LinearLayout gCg;
        TextView gCh;
        ImageView gCi;

        a() {
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return false;
    }

    public void vi(int i) {
        if (this.gyU != null) {
            this.gyU.setText(i);
        }
    }

    public void bBb() {
        if (this.mLayBottom != null) {
            this.mLayBottom.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.f(this.gyU, R.color.cp_link_tip_a, 1);
    }
}
