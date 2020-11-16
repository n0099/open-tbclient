package com.baidu.tbadk.mutiprocess.location;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.c;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.mutiprocess.b;
import com.baidu.tbadk.mutiprocess.g;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.LocationSocketRequestMessage;
import com.baidu.tieba.tbadkCore.location.LocationSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
/* loaded from: classes.dex */
public class a implements b<LocationEvent> {
    private c fsK = new c(CmdConfigSocket.CMD_GET_LOCATION, true) { // from class: com.baidu.tbadk.mutiprocess.location.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                LocationEvent locationEvent = new LocationEvent();
                locationEvent.setType(1);
                locationEvent.eventType = 1;
                locationEvent.errorCode = socketResponsedMessage.getError();
                locationEvent.errorMsg = socketResponsedMessage.getErrorString();
                if (socketResponsedMessage instanceof LocationSocketResponsedMessage) {
                    locationEvent.locationData = ((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData();
                }
                if (socketResponsedMessage.getError() == 0 && locationEvent.locationData != null) {
                    LocationModel.c(locationEvent.locationData);
                    com.baidu.tieba.tbadkCore.location.b.dKB().setTimeStamp(System.currentTimeMillis());
                    com.baidu.tieba.tbadkCore.location.b.dKB().setLocationData(locationEvent.locationData);
                }
                g.publishEvent(locationEvent);
            }
        }
    };

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mutiprocess.b
    public boolean a(LocationEvent locationEvent) {
        if (locationEvent != null) {
            if (locationEvent.getType() == 3) {
                MessageManager.getInstance().unRegisterListener(this.fsK);
                MessageManager.getInstance().registerListener(this.fsK);
                LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
                locationSocketRequestMessage.setLat(locationEvent.lat);
                locationSocketRequestMessage.setLng(locationEvent.lng);
                MessageManager.getInstance().sendMessage(locationSocketRequestMessage);
            } else if (locationEvent.eventType == 1) {
                LocationSocketResponsedMessage locationSocketResponsedMessage = new LocationSocketResponsedMessage();
                locationSocketResponsedMessage.setError(locationEvent.errorCode);
                locationSocketResponsedMessage.setErrorString(locationEvent.errorMsg);
                locationSocketResponsedMessage.setLocationData(locationEvent.locationData);
                MessageManager.getInstance().dispatchResponsedMessage(locationSocketResponsedMessage);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(locationEvent.isShowLocation, locationEvent.locName, locationEvent.locAddr, locationEvent.locSn));
            }
        }
        return false;
    }
}
