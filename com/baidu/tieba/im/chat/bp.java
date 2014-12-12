package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.chat.stranger.MsgReplyCardView;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.List;
/* loaded from: classes.dex */
public class bp extends BaseAdapter {
    public static final int LIST_CLICK_TYPE_MSG_BIG_EMOTION = 7;
    public static final int LIST_CLICK_TYPE_MSG_EXTRA_SHARE_FROM_GAME_CENTER = 11;
    public static final int LIST_CLICK_TYPE_MSG_EXTRA_SHARE_FROM_GAME_CENTER_IMAGE_TAIL = 13;
    public static final int LIST_CLICK_TYPE_MSG_EXTRA_SHARE_FROM_GAME_CENTER_TAIL = 12;
    public static final int LIST_CLICK_TYPE_MSG_EXTRA_SHARE_FROM_PB = 10;
    public static final int LIST_CLICK_TYPE_MSG_GROUP_ACTIVITY = 8;
    public static final int LIST_CLICK_TYPE_MSG_MULTI_IMAGE_TEXT = 9;
    public static final int LIST_CLICK_TYPE_MSG_PIC = 4;
    public static final int LIST_CLICK_TYPE_MSG_REPLY_CARD = 14;
    public static final int LIST_CLICK_TYPE_MSG_TEXT = 3;
    public static final int LIST_CLICK_TYPE_MSG_VOICE = 5;
    public static final int LIST_CLICK_TYPE_PORTRAIT = 2;
    public static final int LIST_CLICK_TYPE_PORTRAIT_RIGHT = 6;
    public static final int LIST_CLICK_TYPE_RESEND = 1;
    private static final int VIEW_TYPE_COUNT = 7;
    private static final int VIEW_TYPE_MSG_CHAT_ROOM_RULE = 4;
    private static final int VIEW_TYPE_MSG_GROUP_ACTIVITY = 5;
    private static final int VIEW_TYPE_MSG_LEFT = 0;
    private static final int VIEW_TYPE_MSG_MID = 2;
    private static final int VIEW_TYPE_MSG_MULTI_PIC_TEXT = 6;
    private static final int VIEW_TYPE_MSG_REPLY_CARD = 7;
    private static final int VIEW_TYPE_MSG_RIGHT = 1;
    private static final int VIEW_TYPE_MSG_TOPIC = 3;
    private TbPageContext<MsglistActivity<?>> mContext;
    private List<ChatMessage> mData = null;
    private Long mCurrentTime = 0L;
    private long mGid = 0;
    private Long mOldestMid = null;
    private Long mNewestMid = null;
    private com.baidu.adp.lib.c.a mItemViewClickListener = null;
    private com.baidu.adp.lib.c.b mItemViewLongClickListener = null;
    private boolean mNeedShowName = true;
    private boolean mIsPersonal = false;

    public bp(TbPageContext<MsglistActivity<?>> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void setNeedShowName(boolean z) {
        this.mNeedShowName = z;
    }

    public void setIsPersonal(boolean z) {
        this.mIsPersonal = z;
    }

    public void genCurrentTime() {
        this.mCurrentTime = Long.valueOf(System.currentTimeMillis() / 1000);
    }

    public void setOnItemViewClickListener(com.baidu.adp.lib.c.a aVar) {
        this.mItemViewClickListener = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.mItemViewLongClickListener = bVar;
    }

    public void setGid(long j) {
        this.mGid = j;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int size;
        if (this.mData == null || (size = this.mData.size()) < 0) {
            return 0;
        }
        return size;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mData == null || i >= this.mData.size()) {
            return null;
        }
        return this.mData.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        MsgReplyCardView msgReplyCardView;
        MsgActivityView msgActivityView;
        av avVar;
        ay ayVar;
        aw awVar;
        MsgleftView msgleftView;
        MsgrightView msgrightView;
        MsgleftView msgleftView2;
        MsgMultiImageTextView msgMultiImageTextView = null;
        int itemViewType = getItemViewType(i);
        ChatMessage chatMessage = this.mData.get(i);
        if (chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        switch (itemViewType) {
            case 0:
                if (view == null) {
                    msgleftView2 = new MsgleftView(this.mContext);
                    view = msgleftView2.getConvertView();
                } else {
                    msgleftView2 = (MsgleftView) view.getTag();
                }
                msgleftView2.setNeedShowName(this.mNeedShowName);
                msgleftView2.setIsPersonal(this.mIsPersonal);
                chatMessage.getCacheData().setIs_left(1);
                msgActivityView = null;
                avVar = null;
                ayVar = null;
                awVar = null;
                msgleftView = msgleftView2;
                msgReplyCardView = null;
                break;
            case 1:
                if (view == null) {
                    msgrightView = new MsgrightView(this.mContext);
                    view = msgrightView.getConvertView();
                } else {
                    msgrightView = (MsgrightView) view.getTag();
                }
                msgrightView.setIsPersonal(this.mIsPersonal);
                chatMessage.getCacheData().setIs_left(0);
                msgActivityView = null;
                avVar = null;
                ayVar = null;
                awVar = null;
                msgleftView = msgrightView;
                msgReplyCardView = null;
                break;
            case 2:
                if (view == null) {
                    aw awVar2 = new aw(this.mContext);
                    view = awVar2.getConvertView();
                    msgActivityView = null;
                    avVar = null;
                    ayVar = null;
                    awVar = awVar2;
                    msgleftView = null;
                    msgReplyCardView = null;
                    break;
                } else {
                    msgActivityView = null;
                    avVar = null;
                    ayVar = null;
                    awVar = (aw) view.getTag();
                    msgleftView = null;
                    msgReplyCardView = null;
                    break;
                }
            case 3:
                if (view == null) {
                    ay ayVar2 = new ay(this.mContext);
                    view = ayVar2.getConvertView();
                    msgActivityView = null;
                    avVar = null;
                    ayVar = ayVar2;
                    awVar = null;
                    msgleftView = null;
                    msgReplyCardView = null;
                    break;
                } else {
                    msgActivityView = null;
                    avVar = null;
                    ayVar = (ay) view.getTag();
                    awVar = null;
                    msgleftView = null;
                    msgReplyCardView = null;
                    break;
                }
            case 4:
                if (view == null) {
                    av avVar2 = new av(this.mContext);
                    view = avVar2.getConvertView();
                    msgActivityView = null;
                    avVar = avVar2;
                    ayVar = null;
                    awVar = null;
                    msgleftView = null;
                    msgReplyCardView = null;
                    break;
                } else {
                    msgActivityView = null;
                    avVar = (av) view.getTag();
                    ayVar = null;
                    awVar = null;
                    msgleftView = null;
                    msgReplyCardView = null;
                    break;
                }
            case 5:
                if (view == null) {
                    MsgActivityView msgActivityView2 = new MsgActivityView(this.mContext);
                    view = msgActivityView2.getConvertView();
                    msgActivityView = msgActivityView2;
                    avVar = null;
                    ayVar = null;
                    awVar = null;
                    msgleftView = null;
                    msgReplyCardView = null;
                    break;
                } else {
                    msgActivityView = (MsgActivityView) view.getTag();
                    avVar = null;
                    ayVar = null;
                    awVar = null;
                    msgleftView = null;
                    msgReplyCardView = null;
                    break;
                }
            case 6:
                if (view == null) {
                    MsgMultiImageTextView msgMultiImageTextView2 = new MsgMultiImageTextView(this.mContext);
                    view = msgMultiImageTextView2.getConvertView();
                    msgActivityView = null;
                    avVar = null;
                    ayVar = null;
                    awVar = null;
                    msgleftView = null;
                    msgReplyCardView = null;
                    msgMultiImageTextView = msgMultiImageTextView2;
                    break;
                } else {
                    msgActivityView = null;
                    avVar = null;
                    ayVar = null;
                    awVar = null;
                    msgleftView = null;
                    msgReplyCardView = null;
                    msgMultiImageTextView = (MsgMultiImageTextView) view.getTag();
                    break;
                }
            case 7:
                if (view == null) {
                    msgReplyCardView = new MsgReplyCardView(this.mContext);
                    view = msgReplyCardView.getConvertView();
                    msgActivityView = null;
                    avVar = null;
                    ayVar = null;
                    awVar = null;
                    msgleftView = null;
                    break;
                } else {
                    msgReplyCardView = (MsgReplyCardView) view.getTag();
                    msgActivityView = null;
                    avVar = null;
                    ayVar = null;
                    awVar = null;
                    msgleftView = null;
                    break;
                }
            default:
                msgReplyCardView = null;
                msgActivityView = null;
                avVar = null;
                ayVar = null;
                awVar = null;
                msgleftView = null;
                break;
        }
        if (msgleftView != null) {
            msgleftView.setOnItemViewClickListener(this.mItemViewClickListener);
            msgleftView.setOnItemViewLongClickListener(this.mItemViewLongClickListener);
            msgleftView.setPosition(i);
            msgleftView.setGid(this.mGid);
            msgleftView.Q(this.mCurrentTime.longValue());
            if (i > 0) {
                msgleftView.P(this.mData.get(i - 1).getTime());
            } else {
                msgleftView.P(0L);
            }
            msgleftView.a(viewGroup, chatMessage);
            msgleftView.b(viewGroup, chatMessage);
        } else if (awVar != null) {
            awVar.setData(chatMessage);
        } else if (ayVar != null) {
            ayVar.setData(chatMessage);
        } else if (avVar != null) {
            avVar.setData(chatMessage);
        } else if (msgActivityView != null) {
            msgActivityView.setPosition(i);
            msgActivityView.setData(chatMessage);
            msgActivityView.setOnItemViewClickListener(this.mItemViewClickListener);
            msgActivityView.setOnItemViewLongClickListener(this.mItemViewLongClickListener);
            msgActivityView.Q(this.mCurrentTime.longValue());
            if (i > 0) {
                msgActivityView.P(this.mData.get(i - 1).getTime());
            } else {
                msgActivityView.P(0L);
            }
        } else if (msgMultiImageTextView != null) {
            msgMultiImageTextView.setOnItemViewLongClickListener(this.mItemViewLongClickListener);
            msgMultiImageTextView.setPosition(i);
            msgMultiImageTextView.Q(this.mCurrentTime.longValue());
            if (i > 0) {
                msgMultiImageTextView.P(this.mData.get(i - 1).getTime());
            } else {
                msgMultiImageTextView.P(0L);
            }
            msgMultiImageTextView.a(this.mContext, chatMessage, viewGroup);
        } else if (msgReplyCardView != null) {
            msgReplyCardView.a(this.mContext, chatMessage, viewGroup);
            msgReplyCardView.setOnItemViewClickListener(this.mItemViewClickListener);
            msgReplyCardView.setPosition(i);
        }
        this.mContext.getLayoutMode().ab(false);
        this.mContext.getLayoutMode().h(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        try {
            ChatMessage chatMessage = this.mData.get(i);
            if (chatMessage != null) {
                if (chatMessage.getMsgType() == 11) {
                    return 2;
                }
                if (chatMessage.getMsgType() == 12) {
                    return 3;
                }
                if (chatMessage.getMsgType() == 13) {
                    return 4;
                }
                if (chatMessage.getMsgType() == 6) {
                    return 5;
                }
                if (chatMessage.getMsgType() == 7) {
                    return 6;
                }
                if (chatMessage.getMsgType() == 23) {
                    return 7;
                }
                if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId() != null) {
                    return chatMessage.getUserInfo().getUserId().equals(TbadkCoreApplication.getCurrentAccount()) ? 1 : 0;
                }
            }
        } catch (Exception e) {
        }
        return 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 7;
    }

    public List<ChatMessage> getData() {
        return this.mData;
    }

    public void nofityDataChanged(ChatMessage chatMessage) {
        notifyDataSetChanged();
    }

    public void setData(List<ChatMessage> list) {
        this.mData = list;
        int size = this.mData.size();
        if (size > 0) {
            this.mNewestMid = Long.valueOf(this.mData.get(size - 1).getMsgId());
            this.mOldestMid = Long.valueOf(this.mData.get(0).getMsgId());
            return;
        }
        this.mNewestMid = null;
        this.mOldestMid = null;
    }

    public Long getNewestMid() {
        return this.mNewestMid;
    }

    public Long getOldestMid() {
        return this.mOldestMid;
    }
}
