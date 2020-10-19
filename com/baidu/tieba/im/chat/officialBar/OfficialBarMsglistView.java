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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.ISendVoiceView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.im.view.OfficialSecondMenuPopupWindow;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes26.dex */
public class OfficialBarMsglistView extends CommonPersonalMsglistView {
    private LinearLayout ixh;
    private TextView jCz;
    private ImageView jGe;
    private LinearLayout jGf;
    private LinearLayout jGg;
    private OfficialSecondMenuPopupWindow jGh;
    private a[] jGi;
    private boolean jGj;

    public OfficialBarMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.jGj = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        String string = talkableActivity.getPageContext().getString(R.string.forum_detail_title);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_info_btn, talkableActivity);
            this.mNavigationBar.showBottomLine();
            this.jCz = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.jCz.setText(string);
        }
        this.ixh = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_stub)).inflate();
        this.ixh.setVisibility(0);
        this.jGe = (ImageView) this.ixh.findViewById(R.id.official_bar_toggle_button);
        this.jGe.setVisibility(0);
        this.jGi = new a[3];
        a aVar = new a();
        aVar.bpm = false;
        aVar.jGn = (LinearLayout) this.ixh.findViewById(R.id.menu_frist);
        aVar.jGo = (TextView) this.ixh.findViewById(R.id.menu_frist_text);
        aVar.jGp = (ImageView) this.ixh.findViewById(R.id.menu_frist_tip);
        this.jGi[0] = aVar;
        a aVar2 = new a();
        aVar2.bpm = false;
        aVar2.jGn = (LinearLayout) this.ixh.findViewById(R.id.menu_second);
        aVar2.jGo = (TextView) this.ixh.findViewById(R.id.menu_second_text);
        aVar2.jGp = (ImageView) this.ixh.findViewById(R.id.menu_second_tip);
        this.jGi[1] = aVar2;
        a aVar3 = new a();
        aVar3.bpm = false;
        aVar3.jGn = (LinearLayout) this.ixh.findViewById(R.id.menu_third);
        aVar3.jGo = (TextView) this.ixh.findViewById(R.id.menu_third_text);
        aVar3.jGp = (ImageView) this.ixh.findViewById(R.id.menu_third_tip);
        this.jGi[2] = aVar3;
        for (int i = 0; i < 3; i++) {
            this.jGi[i].jGn.setOnClickListener(talkableActivity);
        }
        this.jGf = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_down_line)).inflate();
        this.jGf.setVisibility(0);
        this.jGg = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_menu_loading)).inflate();
        this.jGg.setVisibility(8);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.jGe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OfficialBarMsglistView.this.ra(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsglist(MsglistActivity msglistActivity) {
        super.initMsglist(msglistActivity);
        this.jGh = new OfficialSecondMenuPopupWindow(msglistActivity.getPageContext().getPageActivity());
        getListMain().addView(this.jGh);
        this.jGh.setVisibility(8);
        this.jGh.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
        this.jGj = true;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initMsgSend(TalkableActivity talkableActivity) {
        this.mTool = new EditorTools(talkableActivity.getActivity());
        this.mTool.setBarMaxLauCount(1);
        this.mTool.setMoreButtonAtEnd(true);
        this.mTool.setDeskBackgroundColorId(R.color.cp_bg_line_h);
        this.mTool.setMoreDeskBgColorId(R.color.cp_bg_line_h);
        this.mTool.jF(true);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_CHAT_SEND_VOICE_VIEW, m.class, talkableActivity.getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.mSendTool = (m) runTask.getData();
            if (this.mSendTool.eYZ != null && (this.mSendTool.eYZ instanceof ISendVoiceView)) {
                this.mSendVoiceView = (ISendVoiceView) this.mSendTool.eYZ;
                if (this.mSendVoiceView instanceof View) {
                    ((View) this.mSendVoiceView).setOnTouchListener(this.mContext);
                }
            }
            this.mSendTool.eZS = 1;
            this.mTool.b(this.mSendTool);
        }
        this.mTool.b(new com.baidu.tbadk.editortools.imagetool.d(talkableActivity.getActivity(), 2));
        ArrayList arrayList = new ArrayList();
        arrayList.add(6);
        arrayList.add(10);
        arrayList.add(5);
        this.mTool.bj(arrayList);
        m qP = this.mTool.qP(5);
        if (qP != null) {
            qP.eZS = 3;
        }
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(talkableActivity.getActivity(), false);
        aVar.setIsOnlyLocalEmotion(true);
        if (aVar.eYZ != null && (aVar.eYZ instanceof EditText)) {
            ((EditText) aVar.eYZ).setTextSize(0, talkableActivity.getActivity().getResources().getDimensionPixelSize(R.dimen.ds34));
        }
        this.mTool.b(aVar);
        com.baidu.tbadk.editortools.sendtool.a aVar2 = new com.baidu.tbadk.editortools.sendtool.a(talkableActivity.getActivity());
        aVar2.setText(R.string.send_msg);
        this.mTool.b(aVar2);
        if (this.jGj) {
            this.mTool.b(new com.baidu.tieba.im.chat.officialBar.a(talkableActivity.getActivity()));
        }
        this.mTool.build();
        this.mInputControl.addView(this.mTool, new ViewGroup.LayoutParams(-1, -2));
        this.mTool.setActionListener(24, this.mActionListener);
        this.mTool.setActionListener(8, this.mActionListener);
        this.mTool.setActionListener(4, this.mActionListener);
        this.mTool.setActionListener(14, this.mActionListener);
        if (TbadkCoreApplication.getInst().isFaceShopNew()) {
            this.mTool.b(new com.baidu.tbadk.editortools.a(2, 5, "N"));
        }
        if (this.jGj) {
            this.mTool.setActionListener(30, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.2
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar3) {
                    OfficialBarMsglistView.this.ra(true);
                }
            });
        }
    }

    public OfficialSecondMenuPopupWindow cJy() {
        return this.jGh;
    }

    public void af(boolean z, boolean z2) {
        if (this.jGj != z) {
            if (!this.jGj) {
                this.mTool.jH(false);
                return;
            }
            this.ixh.setVisibility(0);
            if (this.mTool != null) {
                this.mTool.hide();
            }
            this.jGf.setVisibility(0);
            return;
        }
        this.jGj = !z;
        if (z) {
            this.ixh.setVisibility(8);
            if (this.mTool != null) {
                this.mInputControl.removeView(this.mTool);
                initMsgSend(this.mContext);
                this.mTool.onChangeSkinType(0);
                if (z2) {
                    this.mTool.jH(true);
                } else {
                    this.mTool.jH(false);
                }
            }
            this.jGf.setVisibility(8);
            return;
        }
        if (this.mTool != null) {
            this.mInputControl.removeView(this.mTool);
            initMsgSend(this.mContext);
            this.mTool.onChangeSkinType(0);
        }
        this.ixh.setVisibility(0);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.jGf.setVisibility(0);
    }

    public a[] cJz() {
        return this.jGi;
    }

    public void dI(List<com.baidu.tieba.im.data.b> list) {
        if (list != null && list.size() == 3) {
            for (int i = 0; i < 3; i++) {
                com.baidu.tieba.im.data.b bVar = list.get(i);
                this.jGi[i].jGo.setText(bVar.getName());
                if (bVar.cLe() != 0) {
                    this.jGi[i].jGp.setVisibility(8);
                }
            }
        }
    }

    public void qZ(boolean z) {
        this.jGg.setVisibility(z ? 0 : 8);
    }

    public void ra(final boolean z) {
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
                    OfficialBarMsglistView.this.ixh.setVisibility(0);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.hide();
                    }
                } else {
                    OfficialBarMsglistView.this.ixh.setVisibility(8);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.display();
                    }
                    for (int i = 0; i < 3; i++) {
                        a aVar = OfficialBarMsglistView.this.jGi[i];
                        if (aVar.bpm) {
                            aVar.bpm = false;
                            OfficialBarMsglistView.this.aa(i, aVar.bpm);
                            OfficialBarMsglistView.this.jGh.QJ();
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

    public void aa(int i, boolean z) {
        a aVar = this.jGi[i];
        if (z) {
            aVar.jGp.setImageResource(R.drawable.icon_bottombar_arrow_s);
            aVar.jGo.setTextColor(this.mContext.getResources().getColor(R.color.cp_link_tip_a));
            return;
        }
        aVar.jGp.setImageResource(R.drawable.icon_bottombar_arrow_n);
        aVar.jGo.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_f));
    }

    public int cK(View view) {
        for (int i = 0; i < 3; i++) {
            if (view == this.jGi[i].jGn) {
                return i;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public static class a {
        boolean bpm;
        LinearLayout jGn;
        TextView jGo;
        ImageView jGp;

        a() {
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return false;
    }

    public void BU(int i) {
        if (this.jCz != null) {
            this.jCz.setText(i);
        }
    }

    public void cJA() {
        if (this.mLayBottom != null) {
            this.mLayBottom.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setViewTextColor(this.jCz, R.color.cp_link_tip_a, 1);
    }
}
