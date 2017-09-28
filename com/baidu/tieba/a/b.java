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
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tbadk.data.e, com.baidu.tbadk.i.c> {
    private com.baidu.tieba.story.c baq;
    private TbPageContext<?> mG;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), com.baidu.tbadk.data.e.azg, bdUniqueId);
        this.mG = tbPageContext;
    }

    public void a(com.baidu.tieba.story.c cVar) {
        this.baq = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: d */
    public com.baidu.tbadk.i.c onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tbadk.i.c(LayoutInflater.from(this.mG.getPageActivity()).inflate(d.j.entrance_pic_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.data.e eVar, com.baidu.tbadk.i.c cVar) {
        if (cVar == null || eVar == null) {
            return null;
        }
        a(cVar, (com.baidu.tbadk.data.e) getItem(i), view, i);
        return view;
    }

    private void a(com.baidu.tbadk.i.c cVar, final com.baidu.tbadk.data.e eVar, View view, final int i) {
        if (cVar != null && eVar != null) {
            cVar.aEO.getInnerImg().setIsRound(true);
            cVar.aEO.getInnerImg().c(eVar.portrait, 12, false);
            cVar.aEO.setOuterColor(d.e.cp_link_tip_g);
            if (eVar.azc == i) {
                if (eVar.azd == 1) {
                    cVar.aEO.a(null, i);
                    if (TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(eVar.user_id))) {
                        cVar.setStatus(eVar.has_read != 1 ? 0 : 2);
                        cVar.mName.setText(1 == eVar.mStatus ? this.mContext.getString(d.l.sending_type) : this.mContext.getString(d.l.my_story));
                    } else {
                        cVar.mName.setText(eVar.user_name);
                    }
                } else {
                    cVar.aEO.we();
                    if (TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(eVar.user_id))) {
                        if (eVar.mStatus == 3) {
                            cVar.aEO.aK(false);
                            cVar.mName.setText(this.mContext.getString(d.l.post_story_fail));
                            cVar.setStatus(3);
                        } else {
                            if (eVar.has_read == 1) {
                                cVar.setStatus(2);
                                cVar.aEO.aJ(true);
                            } else {
                                cVar.setStatus(0);
                                cVar.aEO.aJ(false);
                            }
                            cVar.aEO.aK(true);
                            cVar.mName.setText(this.mContext.getString(d.l.my_story));
                        }
                    } else {
                        if (eVar.has_read == 1) {
                            cVar.setStatus(2);
                            cVar.aEO.aJ(true);
                        } else {
                            cVar.setStatus(0);
                            cVar.aEO.aJ(false);
                        }
                        cVar.mName.setText(eVar.user_name);
                    }
                    eVar.azc = -1;
                }
            } else {
                cVar.aEO.we();
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(eVar.user_id))) {
                    if (eVar.mStatus == 3) {
                        cVar.aEO.aK(false);
                        cVar.mName.setText(this.mContext.getString(d.l.post_story_fail));
                        cVar.setStatus(3);
                    } else {
                        if (eVar.has_read == 1) {
                            cVar.setStatus(2);
                            cVar.aEO.aJ(true);
                        } else {
                            cVar.setStatus(0);
                            cVar.aEO.aJ(false);
                        }
                        cVar.mName.setText(this.mContext.getString(d.l.my_story));
                    }
                } else {
                    if (eVar.has_read == 1) {
                        cVar.setStatus(2);
                        cVar.aEO.aJ(true);
                    } else {
                        cVar.setStatus(0);
                        cVar.aEO.aJ(false);
                    }
                    cVar.mName.setText(eVar.user_name);
                }
            }
            cVar.aEO.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.a.b.1
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
            cVar.aEO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.a.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.baq.a(eVar, i);
                }
            });
            cVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
