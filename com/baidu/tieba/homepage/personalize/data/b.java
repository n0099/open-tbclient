package com.baidu.tieba.homepage.personalize.data;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.i;
import com.baidu.tieba.card.data.p;
import tbclient.Personalized.CardForum;
import tbclient.Personalized.PersonalForum;
/* loaded from: classes9.dex */
public class b extends i implements p {
    private CardForum heO;

    public void a(CardForum cardForum) {
        if (cardForum != null) {
            this.heO = cardForum;
            this.mGroupTitle = cardForum.card_title;
            if (cardForum.position != null) {
                setYuelaouLocate(bvw() + cardForum.position.intValue());
            } else {
                setYuelaouLocate(bvw() + 0);
            }
            if (v.getCount(cardForum.forum_list) > 0) {
                for (PersonalForum personalForum : cardForum.forum_list) {
                    if (personalForum != null && !TextUtils.isEmpty(personalForum.forum_name) && personalForum.forum_id.longValue() > 0) {
                        com.baidu.tieba.card.data.g gVar = new com.baidu.tieba.card.data.g();
                        gVar.forumAvatar = personalForum.avatar;
                        gVar.forumName = personalForum.forum_name;
                        gVar.forumId = com.baidu.adp.lib.f.b.toInt("" + personalForum.forum_id, -1);
                        gVar.isLiked = personalForum.is_like.intValue() == 1;
                        b(gVar);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        if (this.heO != null) {
            return this.heO.position.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean bvu() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void ks(boolean z) {
        this.showTopDivider = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void kt(boolean z) {
        this.showBottomDivider = z;
    }

    public boolean isValidate() {
        if (v.getCount(getDataList()) > 0) {
            return true;
        }
        return false;
    }

    public static boolean vt(int i) {
        return i == 1;
    }
}
