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
    private LinearLayout fAA;
    private ImageView gBe;
    private LinearLayout gBf;
    private LinearLayout gBg;
    private OfficialSecondMenuPopupWindow gBh;
    private a[] gBi;
    private boolean gBj;
    private TextView gyc;

    public OfficialBarMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.gBj = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        String string = talkableActivity.getPageContext().getString(R.string.forum_detail_title);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_info_btn, talkableActivity);
            this.mNavigationBar.showBottomLine();
            this.gyc = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.gyc.setText(string);
        }
        this.fAA = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_stub)).inflate();
        this.fAA.setVisibility(0);
        this.gBe = (ImageView) this.fAA.findViewById(R.id.official_bar_toggle_button);
        this.gBe.setVisibility(0);
        this.gBi = new a[3];
        a aVar = new a();
        aVar.gBn = false;
        aVar.gBo = (LinearLayout) this.fAA.findViewById(R.id.menu_frist);
        aVar.gBp = (TextView) this.fAA.findViewById(R.id.menu_frist_text);
        aVar.gBq = (ImageView) this.fAA.findViewById(R.id.menu_frist_tip);
        this.gBi[0] = aVar;
        a aVar2 = new a();
        aVar2.gBn = false;
        aVar2.gBo = (LinearLayout) this.fAA.findViewById(R.id.menu_second);
        aVar2.gBp = (TextView) this.fAA.findViewById(R.id.menu_second_text);
        aVar2.gBq = (ImageView) this.fAA.findViewById(R.id.menu_second_tip);
        this.gBi[1] = aVar2;
        a aVar3 = new a();
        aVar3.gBn = false;
        aVar3.gBo = (LinearLayout) this.fAA.findViewById(R.id.menu_third);
        aVar3.gBp = (TextView) this.fAA.findViewById(R.id.menu_third_text);
        aVar3.gBq = (ImageView) this.fAA.findViewById(R.id.menu_third_tip);
        this.gBi[2] = aVar3;
        for (int i = 0; i < 3; i++) {
            this.gBi[i].gBo.setOnClickListener(talkableActivity);
        }
        this.gBf = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_down_line)).inflate();
        this.gBf.setVisibility(0);
        this.gBg = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_menu_loading)).inflate();
        this.gBg.setVisibility(8);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.gBe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.1
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
        this.gBh = new OfficialSecondMenuPopupWindow(msglistActivity.getPageContext().getPageActivity());
        getListMain().addView(this.gBh);
        this.gBh.setVisibility(8);
        this.gBh.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
        this.gBj = true;
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
            if (this.mSendTool.crT != null && (this.mSendTool.crT instanceof ISendVoiceView)) {
                this.mSendVoiceView = (ISendVoiceView) this.mSendTool.crT;
                if (this.mSendVoiceView instanceof View) {
                    ((View) this.mSendVoiceView).setOnTouchListener(this.mContext);
                }
            }
            this.mSendTool.csJ = 1;
            this.mTool.b(this.mSendTool);
        }
        this.mTool.b(new com.baidu.tbadk.editortools.imagetool.d(talkableActivity.getActivity(), 2));
        ArrayList arrayList = new ArrayList();
        arrayList.add(6);
        arrayList.add(10);
        arrayList.add(5);
        this.mTool.ai(arrayList);
        k kp = this.mTool.kp(5);
        if (kp != null) {
            kp.csJ = 3;
            kp.csH = R.drawable.btn_pb_add_expression;
        }
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(talkableActivity.getActivity(), false);
        aVar.setIsOnlyLocalEmotion(true);
        if (aVar.crT != null && (aVar.crT instanceof EditText)) {
            ((EditText) aVar.crT).setTextSize(0, talkableActivity.getActivity().getResources().getDimensionPixelSize(R.dimen.ds34));
        }
        this.mTool.b(aVar);
        com.baidu.tbadk.editortools.sendtool.a aVar2 = new com.baidu.tbadk.editortools.sendtool.a(talkableActivity.getActivity());
        aVar2.setText(R.string.send_msg);
        this.mTool.b(aVar2);
        if (this.gBj) {
            this.mTool.b(new com.baidu.tieba.im.chat.officialBar.a(talkableActivity.getActivity()));
        }
        this.mTool.arZ();
        this.mInputControl.addView(this.mTool, new ViewGroup.LayoutParams(-1, -2));
        this.mTool.setActionListener(24, this.mActionListener);
        this.mTool.setActionListener(8, this.mActionListener);
        this.mTool.setActionListener(4, this.mActionListener);
        this.mTool.setActionListener(14, this.mActionListener);
        if (TbadkCoreApplication.getInst().isFaceShopNew()) {
            this.mTool.b(new com.baidu.tbadk.editortools.a(2, 5, "N"));
        }
        if (this.gBj) {
            this.mTool.setActionListener(30, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.2
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar3) {
                    OfficialBarMsglistView.this.lQ(true);
                }
            });
        }
    }

    public OfficialSecondMenuPopupWindow bAL() {
        return this.gBh;
    }

    public void S(boolean z, boolean z2) {
        if (this.gBj != z) {
            if (!this.gBj) {
                this.mTool.fj(false);
                return;
            }
            this.fAA.setVisibility(0);
            if (this.mTool != null) {
                this.mTool.hide();
            }
            this.gBf.setVisibility(0);
            return;
        }
        this.gBj = !z;
        if (z) {
            this.fAA.setVisibility(8);
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
            this.gBf.setVisibility(8);
            return;
        }
        if (this.mTool != null) {
            this.mInputControl.removeView(this.mTool);
            initMsgSend(this.mContext);
            this.mTool.onChangeSkinType(0);
        }
        this.fAA.setVisibility(0);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.gBf.setVisibility(0);
    }

    public a[] bAM() {
        return this.gBi;
    }

    public void cQ(List<com.baidu.tieba.im.data.b> list) {
        if (list != null && list.size() == 3) {
            for (int i = 0; i < 3; i++) {
                com.baidu.tieba.im.data.b bVar = list.get(i);
                this.gBi[i].gBp.setText(bVar.getName());
                if (bVar.bCr() != 0) {
                    this.gBi[i].gBq.setVisibility(8);
                }
            }
        }
    }

    public void lP(boolean z) {
        this.gBg.setVisibility(z ? 0 : 8);
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
                    OfficialBarMsglistView.this.fAA.setVisibility(0);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.hide();
                    }
                } else {
                    OfficialBarMsglistView.this.fAA.setVisibility(8);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.qk();
                    }
                    for (int i = 0; i < 3; i++) {
                        a aVar = OfficialBarMsglistView.this.gBi[i];
                        if (aVar.gBn) {
                            aVar.gBn = false;
                            OfficialBarMsglistView.this.J(i, aVar.gBn);
                            OfficialBarMsglistView.this.gBh.bgM();
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
        a aVar = this.gBi[i];
        if (z) {
            aVar.gBq.setImageResource(R.drawable.icon_bottombar_arrow_s);
            aVar.gBp.setTextColor(this.mContext.getResources().getColor(R.color.cp_link_tip_a));
            return;
        }
        aVar.gBq.setImageResource(R.drawable.icon_bottombar_arrow_n);
        aVar.gBp.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_f));
    }

    public int cg(View view) {
        for (int i = 0; i < 3; i++) {
            if (view == this.gBi[i].gBo) {
                return i;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a {
        boolean gBn;
        LinearLayout gBo;
        TextView gBp;
        ImageView gBq;

        a() {
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return false;
    }

    public void vg(int i) {
        if (this.gyc != null) {
            this.gyc.setText(i);
        }
    }

    public void bAN() {
        if (this.mLayBottom != null) {
            this.mLayBottom.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.f(this.gyc, R.color.cp_link_tip_a, 1);
    }
}
