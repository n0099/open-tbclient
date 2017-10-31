package com.baidu.tieba.a;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tbadk.data.g, com.baidu.tbadk.j.e> {
    private com.baidu.tieba.story.c baJ;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), com.baidu.tbadk.data.g.azF, bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.tieba.story.c cVar) {
        this.baJ = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: g */
    public com.baidu.tbadk.j.e onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tbadk.j.e(LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.h.entrance_pic_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.data.g gVar, com.baidu.tbadk.j.e eVar) {
        if (eVar == null || gVar == null) {
            return null;
        }
        a(eVar, (com.baidu.tbadk.data.g) getItem(i), view, i);
        return view;
    }

    private void a(com.baidu.tbadk.j.e eVar, final com.baidu.tbadk.data.g gVar, View view, final int i) {
        if (eVar != null && gVar != null) {
            eVar.aFl.getInnerImg().setIsRound(true);
            eVar.aFl.getInnerImg().startLoad(gVar.portrait, 25, false);
            eVar.aFl.setOuterColor(d.C0080d.cp_link_tip_g);
            if (gVar.azB == i) {
                if (gVar.azC == 1) {
                    eVar.aFl.a(null, i);
                    if (TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(gVar.user_id))) {
                        eVar.setStatus(gVar.has_read != 1 ? 0 : 2);
                        eVar.mName.setText(1 == gVar.mStatus ? this.mContext.getString(d.j.sending_type) : this.mContext.getString(d.j.my_story));
                    } else {
                        eVar.mName.setText(gVar.user_name);
                    }
                } else {
                    eVar.aFl.we();
                    if (TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(gVar.user_id))) {
                        if (gVar.mStatus == 3) {
                            eVar.aFl.aH(false);
                            eVar.mName.setText(this.mContext.getString(d.j.post_story_fail));
                            eVar.setStatus(3);
                        } else {
                            if (gVar.has_read == 1) {
                                eVar.setStatus(2);
                                eVar.aFl.aG(true);
                            } else {
                                eVar.setStatus(0);
                                eVar.aFl.aG(false);
                            }
                            eVar.aFl.aH(true);
                            eVar.mName.setText(this.mContext.getString(d.j.my_story));
                        }
                    } else {
                        if (gVar.has_read == 1) {
                            eVar.setStatus(2);
                            eVar.aFl.aG(true);
                        } else {
                            eVar.setStatus(0);
                            eVar.aFl.aG(false);
                        }
                        eVar.mName.setText(gVar.user_name);
                    }
                    gVar.azB = -1;
                }
            } else {
                eVar.aFl.we();
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(gVar.user_id))) {
                    if (gVar.mStatus == 3) {
                        eVar.aFl.aH(false);
                        eVar.mName.setText(this.mContext.getString(d.j.post_story_fail));
                        eVar.setStatus(3);
                    } else {
                        if (gVar.has_read == 1) {
                            eVar.setStatus(2);
                            eVar.aFl.aG(true);
                        } else {
                            eVar.setStatus(0);
                            eVar.aFl.aG(false);
                        }
                        eVar.mName.setText(this.mContext.getString(d.j.my_story));
                    }
                } else {
                    if (gVar.has_read == 1) {
                        eVar.setStatus(2);
                        eVar.aFl.aG(true);
                    } else {
                        eVar.setStatus(0);
                        eVar.aFl.aG(false);
                    }
                    eVar.mName.setText(gVar.user_name);
                }
            }
            eVar.aFl.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.a.d.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0) {
                        view2.setScaleX(0.8f);
                        view2.setScaleY(0.8f);
                    } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                        view2.setScaleX(1.0f);
                        view2.setScaleY(1.0f);
                    }
                    return view2.onTouchEvent(motionEvent);
                }
            });
            eVar.aFl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.a.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    d.this.baJ.a(gVar, i);
                }
            });
            eVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
